package components;

import java.util.Map;

public interface Formatter {
	public String setArgumentsAndFormat(String status, Map<Integer, Operatable> corridors, String type);
}
