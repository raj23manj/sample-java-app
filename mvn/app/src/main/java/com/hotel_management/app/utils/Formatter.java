package com.hotel_management.app.utils;

import java.util.Map;

import com.hotel_management.app.corridors.Operatable;

public interface Formatter {
	public String setArgumentsAndFormat(String status, Map<Integer, Operatable> corridors, String type);
}
