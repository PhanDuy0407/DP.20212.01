package entity.order;

import entity.media.Media;

public class FactoryOrderItem {
    public FactoryOrderItem(){};
    public static OrderItem orderItem(Media media, int quantity, int price){
        return new OrderItem(media,
                quantity,
                price);
    }
}
