package subsystem;

import entity.payment.CreditCard;
import entity.payment.PaymentTransaction;
import subsystem.interbank.InterbankSubsystemController;

/***
 * The {@code InterbankSubsystem} class is used to communicate with the
 * Interbank to make transaction.
 * 
 * @author hieud
 *
 */
public class InterbankSubsystem implements InterbankInterface {

//Vi pham nguyen tac logical cohesion: Cac method duoi day deu lien quan den nghiep vu ngan hang
//nhung chung ko su dung du lieu gi cua nhau nen co the di chuyen moi method sang cho class khac implements InterbankInterface
	/**
	 * Represent the controller of the subsystem
	 */
	private InterbankSubsystemController ctrl;

	/**
	 * Initializes a newly created {@code InterbankSubsystem} object so that it
	 * represents an Interbank subsystem.
	 */
	public InterbankSubsystem() {
		this.ctrl = new InterbankSubsystemController();
	}

	/**
	 * @see InterbankInterface#payOrder(CreditCard, int,
	 *      String)
	 */
	public PaymentTransaction payOrder(CreditCard card, int amount, String contents) {
		PaymentTransaction transaction = ctrl.payOrder(card, amount, contents);
		return transaction;
	}

	/**
	 * @see InterbankInterface#refund(CreditCard, int,
	 *      String)
	 */
	public PaymentTransaction refund(CreditCard card, int amount, String contents) {
		PaymentTransaction transaction = ctrl.refund(card, amount, contents);
		return transaction;
	}
}
