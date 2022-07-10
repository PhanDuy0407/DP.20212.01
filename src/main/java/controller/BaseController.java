package controller;

import java.util.List;

import entity.cart.Cart;
import entity.cart.CartItem;
import entity.media.Media;

/**
 * This class is the base controller for our AIMS project
 * @author nguyenlm
 */
/*
    SOLID: Vi phạm nguyên lý LSP vì các class kế thừa lớp BaseController này không 
    sử dụng lại các method của lớp con
*/
public class BaseController {
    
    /**
     * The method checks whether the Media in Cart, if it were in, we will return the CartMedia else return null
     * @param media
     * @return CartMedia or null
     */
    public CartItem checkMediaInCart(Media media){
        return SessionInformation.cartInstance.checkMediaInCart(media);
    }

    /**
     * This method gets the list of items in cart
     * @return List[CartMedia]
     */
    public List getListCartMedia(){
        return SessionInformation.cartInstance.getListMedia();
    }
}
