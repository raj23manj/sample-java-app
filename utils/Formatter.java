package utils;

import java.util.Map;

import corridors.Operatable;

public interface Formatter {
	public String setArgumentsAndFormat(String status, Map<Integer, Operatable> corridors, String type);
}
