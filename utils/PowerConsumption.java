package utils;

import java.util.Map;

import floors.Floor;

public class PowerConsumption {

	public void calculatePowerConsumption(Map<Integer, Floor> floors) {
		Integer totalConsumption = 0;
		//Map<Integer, Floor> 
		for(Map.Entry<Integer, Floor> floor : floors.entrySet()) {
			totalConsumption += floor.getValue().totalPowerConsumed(floor.getKey());
		}
	}
}
