package com.hotel_management.app.utils;

import java.util.Map;

import com.hotel_management.app.floors.Floor;

public class PowerConsumption {

	public void calculatePowerConsumption(Map<Integer, Floor> floors) {
		Integer totalConsumption = 0;

		for (Map.Entry<Integer, Floor> floor : floors.entrySet()) {
			totalConsumption += floor.getValue().totalPowerConsumed(floor.getKey());
		}
	}
}
