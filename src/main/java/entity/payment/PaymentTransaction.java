package entity.payment;


/*
	PaymentTransaction
	SOLID: Vi phạm nguyên lý OCP: vì phương thức PaymentTransaction mới chỉ 
	có phương thức thanh toán với creditCard, về sau có nhiều phương thức thanh toán
	sẽ phải modify lại mã nguồn
*/
public class PaymentTransaction {
	private String errorCode;
	private Card card;
	private String transactionId;
	private String transactionContent;
	private int amount;
	private String createdAt;
	
	public PaymentTransaction(String errorCode, Card card, String transactionId, String transactionContent,
                              int amount, String createdAt) {
		super();
		this.errorCode = errorCode;
		this.card = card;
		this.transactionId = transactionId;
		this.transactionContent = transactionContent;
		this.amount = amount;
		this.createdAt = createdAt;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
}
