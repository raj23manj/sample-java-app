package com.hotel_management.app.devices;

import com.hotel_management.app.utils.Constants;

public class Light extends Device {
	@Override
	public Integer powerConsumption() {
		return this.state ? Constants.LIGHT_CONSUMES : Constants.DEFAULT_CONSUMPTION ;
	}
}

