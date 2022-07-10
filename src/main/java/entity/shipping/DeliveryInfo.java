package entity.shipping;

import entity.order.Order;
import org.example.DistanceCalculator;

import adapter.AdapterOldLibDistance;
import common.interfaces.DistanceCalculatorInterface;

/*
    SOLID: Vi phạm nguyên lý OCP vì method calculateShippingFee mới chỉ tính 1 cách
    thành tiền, tính phí có nhiều cách, hoặc sử dụng nhiều lib khác
*/
public class DeliveryInfo {
	//// Vi pham implement singleton: tat ca cac thuoc tinh phai de o access
	//// modifier private
	protected String name;
	protected String phone;
	protected String province;
	protected String address;
	protected String shippingInstructions;
	protected DistanceCalculatorInterface distanceCalculatorInterface;
	private static final double MULTIPLIER = 1.2;

	public DeliveryInfo() {

	}

	public DeliveryInfo(String name, String phone, String province, String address, String shippingInstructions,
			DistanceCalculatorInterface distanceInterface) {
		this.name = name;
		this.phone = phone;
		this.province = province;
		this.address = address;
		this.shippingInstructions = shippingInstructions;
		this.distanceCalculatorInterface = new AdapterOldLibDistance(new DistanceCalculator());
	}

	public int calculateShippingFee(Order order) { // Vi pham nguyen tac Stamp Coupling
		// boi vi truyen doi tuong order vao nhung khong su dung cac thuoc tinh cua doi
		// tuong nay
		int distance = distanceCalculatorInterface.calculateDistance(address, province);
		return (int) (distance * MULTIPLIER);
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
