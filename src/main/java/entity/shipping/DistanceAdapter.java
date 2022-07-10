package entity.shipping;

import org.example.DistanceCalculator;

import common.interfaces.DistanceCalculatorInterface;

public class DistanceAdapter implements CalculatorDistance {
	
	private DistanceCalculatorInterface distanceInterface;
	
	public DistanceAdapter(DistanceCalculatorInterface distanceInterface) {
		// TODO Auto-generated constructor stub
		this.distanceInterface = distanceInterface;
	}

	@Override
	public int calculateDistance(String address, String province) {
		// TODO Auto-generated method stub
		return this.distanceInterface.calculateDistance(address, province);
	}



}
