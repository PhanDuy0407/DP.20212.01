package subsystem.interbank;

import common.exception.*;
import controller.DateController;
import entity.payment.Card;
import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;
import utils.MyMap;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author
 */
public class InterbankPayloadConverter {

    /**
     * Convert from native entity into interbank required format
     * @param card
     * @param amount
     * @param contents
     * @return
     */

    /**
     * Clean code: Chuyển các mã code thành hằng số 
     */
    private static final String Success = "00";
    private static final String InvalidCard = "01";
    private static final String NotEnoughBalance = "02";
    private static final String InternalServerError = "03";
    private static final String SuspiciousTransaction = "04";
    private static final String NotEnoughTransactionInfo = "05";
    private static final String InvalidVersion = "06";
    private static final String InvalidTransactionAmount = "07";

    private static InterbankPayloadConverter instance;
    public synchronized static InterbankPayloadConverter getInstance(){
        if (instance == null){
            instance = new InterbankPayloadConverter();
        }
        return instance;
    }
    String convertToRequestPayload(Card card, int amount, String contents) {
        Map<String, Object> transaction = new MyMap();

        try {
            transaction.putAll(MyMap.toMyMap(card));
        } catch (IllegalArgumentException | IllegalAccessException e) {
            // TODO Auto-generated catch block
            throw new InvalidCardException();
        }
        transaction.put("command", InterbankConfigs.PAY_COMMAND);
        transaction.put("transactionContent", contents);
        transaction.put("amount", amount);
        transaction.put("createdAt", DateController.getToday());

        Map<String, Object> requestMap = new MyMap();
        requestMap.put("version", InterbankConfigs.VERSION);
        requestMap.put("transaction", transaction);

        return ((MyMap) requestMap).toJSON();
    }

    /**
     * Read the response from interbank server
     * @param responseText
     * @return
     */
    PaymentTransaction extractPaymentTransaction(String responseText) {
        MyMap response = convertJSONResponse(responseText);

        if (response == null)
            return null;
        MyMap transaction = (MyMap) response.get("transaction");
        CreditCard card = new CreditCard(
                (String) transaction.get("cardCode"),
                (String) transaction.get("owner"),
                (String) transaction.get("dateExpired"),
                Integer.parseInt((String) transaction.get("cvvCode")));

        PaymentTransaction trans = new PaymentTransaction(
                (String) response.get("errorCode"),
                card,
                (String) transaction.get("transactionId"),
                (String) transaction.get("transactionContent"),
                Integer.parseInt((String) transaction.get("amount")),
                (String) transaction.get("createdAt"));

        switch (trans.getErrorCode()) {
            case Success:
                break;
            case InvalidCard:
                throw new InvalidCardException();
            case NotEnoughBalance:
                throw new NotEnoughBalanceException();
            case InternalServerError:
                throw new InternalServerErrorException();
            case SuspiciousTransaction:
                throw new SuspiciousTransactionException();
            case NotEnoughTransactionInfo :
                throw new NotEnoughTransactionInfoException();
            case InvalidVersion:
                throw new InvalidVersionException();
            case InvalidTransactionAmount:
                throw new InvalidTransactionAmountException();
            default:
                throw new UnrecognizedException();
        }

        return trans;
    }

    /**
     * Convert response from interbank server as JSON-formatted String into a proper Map
     * @param responseText
     * @return
     */
    private MyMap convertJSONResponse(String responseText) {
        MyMap response = null;
        try {
            response = MyMap.toMyMap(responseText, 0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new UnrecognizedException();
        }
        return response;
    }
    //coincidental cohesion vi ham getToday khong can dung chung du lieu voi cac phuong thuc khac trong class.
    //co the tach ra class khac roi goi den
    /**
     * Return a {@link String String} that represents the current time in the format of yyyy-MM-dd HH:mm:ss.
     *
     * @author hieudm
     * @return the current time as {@link String String}.
     */

}
