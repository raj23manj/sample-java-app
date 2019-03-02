package components;

import java.util.HashMap;
import java.util.Map;

public class Floor implements Status<String, Integer> {

	private Map<Integer, Operations> mainCorridors;
	private Map<Integer, Operations> subCorridors;
	private Map<String, Object> completeFloor = new HashMap<String, Object>();;

	public Floor(Map<Integer, Operations> mainCorridor, Map<Integer, Operations> subCorridors) {
		super();
		this.mainCorridors = mainCorridor;
		this.subCorridors = subCorridors;
		this.completeFloor.put(Constants.MAIN_CORRIDOR, mainCorridor);
		this.completeFloor.put(Constants.SUB_CORRIDOR, subCorridors);
		
	}

	public Map<Integer, Operations> getMainCorridor() {
		return mainCorridors;
	}

	public Map<Integer, Operations> getSubCorridors() {
		return subCorridors;
	}

	@Override
	public String getStatus(Integer floorNo) {
		String status = String.format("Floor %d  \n", floorNo);
		
		status = setArgumentsAndFormat(status, mainCorridors, Constants.MAIN);
		status = setArgumentsAndFormat(status, subCorridors, Constants.SUB);
		
		return status;
	}

	@Override
	public String onOrOffStatus(Boolean status) {		
		return status.equals(true) ? Constants.ON : Constants.OFF;
	}
	
	private String setArgumentsAndFormat(String status, Map<Integer, Operations> corridors, String type) {
		Map<String, Object> corridorParameters = new HashMap<>();
		for (Map.Entry<Integer, Operations> corridor : corridors.entrySet())
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
		status += String.format("%s Corridor %d Light %d : %s AC : %s \n", 
								 options.get(Constants.TYPE).toString(),
								 Integer.valueOf(options.get(Constants.CORRIDOR_NO).toString()),
								 Integer.valueOf(options.get(Constants.CORRIDOR_NO).toString()),
								 options.get(Constants.LIGHT_STATUS).toString(),
								 options.get(Constants.AC_STATUS).toString()
				               );
		return status;
	}
	
}
