package controller;

import entity.payment.Card;
import entity.payment.CreditCard;

public class SimpleCardFactory {
    public SimpleCardFactory(){};
    public Card createCard(String type, String cardNumber, String cardHolderName,
                           String expirationDate, String securityCode){
        if (type.equals("CreditCard")){
           return new CreditCard(cardNumber,
                   cardHolderName,
                   expirationDate,
                   Integer.parseInt(securityCode));
        }
        return new Card();
    }
}
