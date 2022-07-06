package entity.invoice;

import entity.cart.Cart;
import entity.order.Order;

public class Invoice {

    private Order order;
    private int amount;
    private static Invoice instance;

    private Invoice(){//Vi pham implement singleton: phuong thuc khoi tao khong duoc dung public, phai dung getInstance

    }

    private Invoice(Order order){
        this.order = order;
        this.amount = order.getTotal();
    }

    public synchronized static Invoice getInstanse() {
        if (instance == null) {
            instance = new Invoice();
        }
        return instance;
    }

    public synchronized static Invoice getInstanse(Order order) {
        if (instance == null) {
            instance = new Invoice();
        }
        instance.order = order;
        instance.amount = order.getTotal();
        return instance;
    }
    public Order getOrder() {
        return order;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void saveInvoice(){

    }
}
