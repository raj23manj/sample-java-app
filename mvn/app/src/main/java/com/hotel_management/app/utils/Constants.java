package com.hotel_management.app.utils;

public final class Constants {
	// corridor related
	public final static String MAIN_CORRIDOR="mainCorridor";
	public final static String SUB_CORRIDOR="subCorridor";
	public final static String TYPE="type";
	public final static String CORRIDOR_NO="corridorNo";
	public final static String MAIN="Main";
	public final static String SUB="Sub";
	
	// Output Messages
	public final static String MESSAGE_1 = "Floor %d  \n";
	public final static String MESSAGE_2 = "%s Corridor %d Light %d : %s AC : %s \n";
	
	// devices
	public final static String AC="AC";
	public final static String LIGHT="Light";
	public final static String LIGHT_STATUS="lightStatus";
	public final static String AC_STATUS="acStatus";
	
	// states
	public final static String ON="ON";
	public final static String OFF="OFF";
	
	// power consumption calculation related
	public final static Integer AC_CONSUMES = 10;
	public final static Integer LIGHT_CONSUMES = 5;
	public final static Integer MAIN_CORRIDOR_CALC = 15;
	public final static Integer SUB_CORRIDOR_CALC = 10;
	public final static Integer DEFAULT_CONSUMPTION = 0;
}
