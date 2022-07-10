package entity.shipping;

import entity.order.Order;
import org.example.DistanceCalculator;

/*
    SOLID: Vi phạm nguyên lý OCP vì method calculateShippingFee mới chỉ tính 1 cách
    thành tiền, tính phí có nhiều cách, hoặc sử dụng nhiều lib khác
*/
public class DeliveryInfo {
    ////Vi pham implement singleton: tat ca cac thuoc tinh phai de o access modifier private
    protected String name;
    protected String phone;
    protected String province;
    protected String address;
    protected String shippingInstructions;
    protected DistanceCalculator distanceCalculator;

    public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions, DistanceCalculator distanceCalculator) {
        this.name = name;
        this.phone = phone;
        this.province = province;
        this.address = address;
        this.shippingInstructions = shippingInstructions;
        this.distanceCalculator = distanceCalculator;
    }

    public static final double COEFFICIENT = 1.2;
    public int calculateShippingFee(Order order) {	//Vi pham nguyen tac Stamp Coupling
    //boi vi truyen doi tuong order vao nhung khong su dung cac thuoc tinh cua doi tuong nay
        int distance = distanceCalculator.calculateDistance(address, province);
        return (int) (distance * COEFFICIENT);
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getProvince() {
        return province;
    }

    public String getAddress() {
        return address;
    }

    public String getShippingInstructions() {
        return shippingInstructions;
    }
}
