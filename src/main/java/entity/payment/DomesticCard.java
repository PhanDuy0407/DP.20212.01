package entity.payment;

public class DomesticCard extends Card{
    public DomesticCard(String cardCode, String owner, String dateExpired) {
        this.cardCode = cardCode;
        this.owner = owner;
        this.dateExpired = dateExpired;
    }
}