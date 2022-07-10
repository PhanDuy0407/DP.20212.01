package subsystem.interbank;

import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;

public class InterbankSubsystemController {

	private static InterbankPayloadConverter interbankPayloadConverter = new InterbankPayloadConverter();
	private static InterbankBoundary interbankBoundary = new InterbankBoundary();

	public PaymentTransaction refund(CreditCard card, int amount, String contents) {	//Vi pham nguyen tac Stamp Coupling
	//boi vi truyen doi tuong card vao nhung khong su dung toi cac thanh phan cua doi tuong
	//class nao implement lai interface refund thi moi can truyen cac doi tuong vao
		return null;
	}

	public PaymentTransaction payOrder(CreditCard card, int amount, String contents) {
		String requestPayload = interbankPayloadConverter.convertToRequestPayload(card, amount, contents);
		String responseText = interbankBoundary.query(InterbankConfigs.PROCESS_TRANSACTION_URL, requestPayload);
		return interbankPayloadConverter.extractPaymentTransaction(responseText);
	}

}
