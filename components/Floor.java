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
		
		Map<String, Object> corridorParametersMain = new HashMap<>();
		Map<String, Object> corridorParametersSub = new HashMap<>();
		String status = String.format("Floor %d  \n", floorNo);
		
		for (Map.Entry<Integer, Operations> mainCorridor : mainCorridors.entrySet())
		{
			corridorParametersMain.put("type", "Main");
			corridorParametersMain.put("corridorNo", mainCorridor.getKey());
			corridorParametersMain.put("lightStatus", "ON");
			corridorParametersMain.put("acStatus", "ON");
			status = getFormattedMessages(status, corridorParametersMain);
			 
		}
		
		for (Map.Entry<Integer, Operations> subCorridor : subCorridors.entrySet())
		{

			corridorParametersSub.put("type", "Sub");
			corridorParametersSub.put("corridorNo", subCorridor.getKey());
			corridorParametersSub.put("lightStatus", "ON");
			corridorParametersSub.put("acStatus", "ON");
			status = getFormattedMessages(status, corridorParametersSub);
		}
		
		return status;
	}

	@Override
	public String onOrOffStatus(Boolean status) {
		
		return null;
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
