package com.hotel_management.app.corridors;

import java.util.ArrayList;
import java.util.List;

import com.hotel_management.app.devices.Switchable;
import com.hotel_management.app.utils.Constants;

public class Corridor implements Operatable {

	protected Switchable light;
	protected Switchable ac;
	protected List<Switchable> devices = new ArrayList<>();

	public Corridor(Switchable light, Switchable ac) {
		super();
		this.light = light;
		this.ac = ac;
		devices.add(this.light);
		devices.add(this.ac);
	}
	
	@Override
	public void deviceOn(String type) {
		switch (type) {
		case Constants.AC:
			ac.turnOn();
			break;
		case Constants.LIGHT:
			light.turnOn();
			break;
		}
	}

	@Override
	public void deviceOff(String type) {
		switch (type) {
		case Constants.AC:
			ac.turnOff();
			break;
		case Constants.LIGHT:
			light.turnOff();
			break;
		}
	}

	@Override
	public Boolean deviceState(String type) {
		Boolean state = null;

		switch (type) {
		case Constants.AC:
			state = ac.getState();
			break;
		case Constants.LIGHT:
			state = light.getState();
			break;
		}
		return state;
	}

	@Override
	public Integer devicePowerConsumption() {
		Integer totalConsumption = 0;

		for (Switchable device : devices) {
			totalConsumption += device.powerConsumption();
		}

		return totalConsumption;
	}

}
