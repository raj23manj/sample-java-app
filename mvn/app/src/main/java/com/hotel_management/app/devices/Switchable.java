package com.hotel_management.app.devices;

public interface Switchable {
	public void turnOn();
	public void turnOff();
	public Boolean getState();
	public Integer powerConsumption();
}

