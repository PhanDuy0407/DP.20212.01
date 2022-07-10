package adapter;

import org.example.DistanceCalculator;

import common.interfaces.DistanceCalculatorInterface;

public class AdapterOldLibDistance implements DistanceCalculatorInterface {
	private DistanceCalculator distanceCalculator;

	public AdapterOldLibDistance(DistanceCalculator distanceCalculator) {
		this.distanceCalculator = distanceCalculator;
	}

	@Override
	public int calculateDistance(String address, String province) {
		// TODO Auto-generated method stub
		return distanceCalculator.calculateDistance(address, province);
	}

}
