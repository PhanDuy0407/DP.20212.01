package entity.shipping;

import common.interfaces.DistanceCalculatorInterface;
import org.example.DistanceCalculator;

public class LastestDistanceCalculate implements DistanceCalculatorInterface {

	@Override
	public int calculateDistance(String address, String province) {
		DistanceCalculator distanceCalculator = new DistanceCalculator();
		return distanceCalculator.calculateDistance(address, province);
	}

}
