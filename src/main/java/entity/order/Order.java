package entity.order;

import controller.FactoryOrderItem;
import controller.SessionInformation;
import entity.cart.Cart;
import entity.cart.CartItem;
import entity.shipping.DeliveryInfo;
import entity.state.CancelState;
import entity.state.OrderingState;
import views.screen.ViewsConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import common.interfaces.State;


public class Order {

    private int shippingFees;
    private int subtotal;
    private int tax;
    private List orderMediaList;
    private State state;
    
    public State getState() {
		return state;
	}

	public void changeState(State state) {
		this.state = state;
	}

	protected DeliveryInfo deliveryInfo;

    public Order() {
        this.shippingFees = 0;
        this.subtotal = 0;
        this.tax = 0;
        this.state = new OrderingState();
    }
    
    public void cancelOrder() {
    	this.changeState(new CancelState());
    }

    public Order(Cart cart) {
        List<OrderItem> orderItems = new ArrayList<>();
        FactoryOrderItem factoryOrderItem = new FactoryOrderItem();
        for (Object object : SessionInformation.cartInstance.getListMedia()) {
            CartItem cartItem = (CartItem) object;
            //Them vao src.main.java.controller.FactoryOrderItem.java
            //public class FactoryOrderItem {
            //    public FactoryOrderItem(){};
            //    public OrderItem orderItem(Media media, int quantity, int price){
            //           return new OrderItem(cartItem.getMedia(),
            //                    cartItem.getQuantity(),
            //                    cartItem.getPrice());
            //    }
            //}
//            OrderItem orderItem = new OrderItem(cartItem.getMedia(),    //nen su dung phuong thuc FactoryOrderItem nhu tren
//                    //vi sau nay co them chuc nang xem chi tiet san pham
//                    cartItem.getQuantity(),
//                    cartItem.getPrice());
            OrderItem orderItem = factoryOrderItem.orderItem(cartItem);
            orderItems.add(orderItem);
        }
        this.orderMediaList = Collections.unmodifiableList(orderItems);
        this.subtotal = cart.calSubtotal();
        this.tax = (int) (ViewsConfig.PERCENT_VAT/100) * subtotal;
    }

    public List getListOrderMedia() {
        return this.orderMediaList;
    }

    public int getShippingFees() {
        if (deliveryInfo == null) return 0;
        return this.shippingFees;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
        this.shippingFees = deliveryInfo.calculateShippingFee(this);
    }

    public List getOrderMediaList() {
        return orderMediaList;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public int getTax() {
        return tax;
    }

    public int getTotal() {
        return this.subtotal + this.tax + this.shippingFees;
    }
}
