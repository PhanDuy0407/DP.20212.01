package subsystem.interbank;

import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;


/*
	Duc anh
	procedural cohesion
	refund when the user wants to return the item
	and pay oder when the user wants by the item
	payorder are made before refunds
*/
public class InterbankSubsystemController {

	private static InterbankPayloadConverter interbankPayloadConverter = InterbankPayloadConverter.getInstance();
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
