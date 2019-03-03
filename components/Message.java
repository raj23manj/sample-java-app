package components;

import java.util.HashMap;
import java.util.Map;

public class Message implements Formatter {
	@Override
	public String setArgumentsAndFormat(String status, Map<Integer, Operatable> corridors, String type) {
		Map<String, Object> corridorParameters = new HashMap<>();
		for (Map.Entry<Integer, Operatable> corridor : corridors.entrySet())
		{
			corridorParameters.put(Constants.TYPE, type);
			corridorParameters.put(Constants.CORRIDOR_NO, corridor.getKey());
			corridorParameters.put(Constants.LIGHT_STATUS, onOrOffStatus(corridor.getValue().lightState()));
			corridorParameters.put(Constants.AC_STATUS, onOrOffStatus(corridor.getValue().acState()));
			status = getFormattedMessages(status, corridorParameters); 
		}
		
		return status;
	}
	
	private String getFormattedMessages(String status, Map<String, Object> options) {
		status += String.format(Constants.MESSAGE_2, 
								 options.get(Constants.TYPE).toString(),
								 Integer.valueOf(options.get(Constants.CORRIDOR_NO).toString()),
								 Integer.valueOf(options.get(Constants.CORRIDOR_NO).toString()),
								 options.get(Constants.LIGHT_STATUS).toString(),
								 options.get(Constants.AC_STATUS).toString()
				               );
		return status;
	}
	
	private String onOrOffStatus(Boolean status) {		
		return status.equals(true) ? Constants.ON : Constants.OFF;
	}
}
