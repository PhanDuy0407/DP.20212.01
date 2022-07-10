package entity.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.exception.MediaNotAvailableException;
import entity.media.Media;

public class Cart {
    private static Cart instance;
    //Vi pham implement singleton: Declare a single private static instance of the class: chi co 1 gio hang nen cart phai la static
    // Content coupling: CartItem chưa
    private List<CartItem> lstCartItem = new ArrayList<>();

    private Cart() {
    }

    public synchronized static Cart getInstanse() {
        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }

    public void addCartMedia(CartItem cm) {
        lstCartItem.add(cm);
    }

    public void removeCartMedia(CartItem cm) {
        lstCartItem.remove(cm);
    }

    public List getListMedia() {
        return lstCartItem;
    }

    public void emptyCart() {
        lstCartItem.clear();
    }

    public int getTotalMedia() {
        int total = 0;
        for (Object obj : lstCartItem) {
            CartItem cm = (CartItem) obj;
            total += cm.getQuantity();
        }
        return total;
    }

    public int calSubtotal() {
        int total = 0;
        for (Object obj : lstCartItem) {
            CartItem cm = (CartItem) obj;
            total += cm.getPrice() * cm.getQuantity();
        }
        return total;
    }

    public void checkAvailabilityOfProduct() throws SQLException {
        boolean allAvailable = true;
        for (Object object : lstCartItem) {
            CartItem cartItem = (CartItem) object;
            int requiredQuantity = cartItem.getQuantity();
            int availQuantity = cartItem.getMedia().getQuantity();
            if (requiredQuantity > availQuantity)
                allAvailable = false;
        }
        if (!allAvailable)
            throw new MediaNotAvailableException("Some media not available");
    }

    public CartItem checkMediaInCart(Media media) {
        for (CartItem cartItem : lstCartItem) {
            if (cartItem.getMedia().getId() == media.getId())
                return cartItem;
        }
        return null;
    }

}
