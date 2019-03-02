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
		
		status = setArgumentsAndFormat(status, mainCorridors);
		status = setArgumentsAndFormat(status, subCorridors);
		
		return status;
	}

	@Override
	public String onOrOffStatus(Boolean status) {
		
		return null;
	}
	
	private String setArgumentsAndFormat(String status, Map<Integer, Operations> corridors) {
		Map<String, Object> corridorParameters = new HashMap<>();
		for (Map.Entry<Integer, Operations> corridor : corridors.entrySet())
		{
			corridorParameters.put("type", "Main");
			corridorParameters.put("corridorNo", corridor.getKey());
			corridorParameters.put("lightStatus", "ON");
			corridorParameters.put("acStatus", "ON");
			status = getFormattedMessages(status, corridorParameters); 
		}
		
		return status;
	}
	
	private String getFormattedMessages(String status, Map<String, Object> options) {
		status += String.format("%s Corridor %d Light %d : %s AC : %s \n", 
								 options.get("type").toString(),
								 Integer.valueOf(options.get("corridorNo").toString()),
								 Integer.valueOf(options.get("corridorNo").toString()),
								 options.get("lightStatus").toString(),
								 options.get("acStatus").toString()
				               );
		return status;
	}
	
}
