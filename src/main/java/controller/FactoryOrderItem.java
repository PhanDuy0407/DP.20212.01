package controller;

import entity.cart.CartItem;
import entity.media.Media;
import entity.order.OrderItem;

public class FactoryOrderItem {

        public FactoryOrderItem(){};
        public OrderItem orderItem(CartItem cartItem){
               return new OrderItem(cartItem.getMedia(),
                        cartItem.getQuantity(),
                        cartItem.getPrice());
        }

}
