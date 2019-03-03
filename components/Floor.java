package components;

import java.util.HashMap;
import java.util.Map;

public class Floor implements Status<String, Integer> {

	private Map<Integer, Operatable> mainCorridors;
	private Map<Integer, Operatable> subCorridors;
	private Map<String, Object> completeFloor = new HashMap<String, Object>();

	public Floor(Map<Integer, Operatable> mainCorridor, Map<Integer, Operatable> subCorridors) {
		super();
		this.mainCorridors = mainCorridor;
		this.subCorridors = subCorridors;
		this.completeFloor.put(Constants.MAIN_CORRIDOR, mainCorridor);
		this.completeFloor.put(Constants.SUB_CORRIDOR, subCorridors);	
	}

	public Map<Integer, Operatable> getMainCorridor() {
		return mainCorridors;
	}

	public Map<Integer, Operatable> getSubCorridors() {
		return subCorridors;
	}

	@Override
	public String getStatus(Integer floorNo) {
		String status = String.format(Constants.MESSAGE_1, floorNo);		
		status = setArgumentsAndFormat(status, mainCorridors, Constants.MAIN);
		status = setArgumentsAndFormat(status, subCorridors, Constants.SUB);		
		return status;
	}

	@Override
	public String onOrOffStatus(Boolean status) {		
		return status.equals(true) ? Constants.ON : Constants.OFF;
	}
	
	private String setArgumentsAndFormat(String status, Map<Integer, Operatable> corridors, String type) {
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
	
}
