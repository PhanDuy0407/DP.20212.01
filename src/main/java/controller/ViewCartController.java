package controller;

import java.sql.SQLException;

import entity.cart.Cart;


public class ViewCartController extends BaseController{
    
    /**
     * This method checks the available products in Cart
     * @throws SQLException
     */
    public void checkAvailabilityOfProduct() throws SQLException{
        SessionInformation.cartInstance.checkAvailabilityOfProduct();
    }

    /**
     * This method calculates the cart subtotal
     * @return subtotal
     */
    public int getCartSubtotal(){
        /**
         * Clean code: data-refactoring move an expression inline
         */
        return SessionInformation.cartInstance.calSubtotal();
    }

}
