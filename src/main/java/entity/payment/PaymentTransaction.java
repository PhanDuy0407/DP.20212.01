package entity.payment;

public class PaymentTransaction {
	private String errorCode;
	private CreditCard card;
	private String transactionId;
	private String transactionContent;
	private int amount;
	private String createdAt;
	
	public PaymentTransaction(String errorCode, CreditCard card, String transactionId, String transactionContent,
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
// lớp này có contrucsion PaymentTransasction nhưng lại truyền vào các giá trị cứng
// nên chỉ thanh toán được với 1 loại card

// ảnh hường: nếu tương lai phát sinh thêm các loại thanh toán mới thì sẽ dẫn đến vieecjphari modify lại code