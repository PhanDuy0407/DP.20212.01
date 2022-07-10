package entity.payment;

public class Card { //Vi pham nguyen ly OCP: neu sau nay muon them phuong thuc thanh toan moi thi phai them interface GeneralPayment chu ko ơhai la java class
    //sau khi them interface thi Card phai implement GeneralPayment
    protected String owner;
    protected String dateExpired;
    protected String cardCode;
    //@implement
    // public void PaymentByCard();
}
