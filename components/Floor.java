package components;

import java.util.HashMap;
import java.util.Map;

public class Floor implements Status<String, Integer> {

	private Operations mainCorridor;
	private Map<Integer, Operations> subCorridors;
	private Map<String, Object> completeFloor = new HashMap<String, Object>();;

	public Floor(Corridor mainCorridor, Map<Integer, Operations> subCorridors) {
		super();
		this.mainCorridor = mainCorridor;
		this.subCorridors = subCorridors;
		this.completeFloor.put(Constants.MAIN_CORRIDOR, mainCorridor);
		this.completeFloor.put(Constants.SUB_CORRIDOR, subCorridors);
		
	}

	public Operations getMainCorridor() {
		return mainCorridor;
	}

	public Map<Integer, Operations> getSubCorridors() {
		return subCorridors;
	}

	@Override
	public String getStatus(Integer floorNo) {
		String status = String.format("Floor %d  \n", floorNo);
		
		for (Map.Entry<Integer, Operations> subCorridor : subCorridors.entrySet())
		{
		    //System.out.println(subCorridor.getKey() + "/" + subCorridor.getValue());
		    status += String.format("Sub Corridor %d \n", subCorridor.getKey());
		}
		
		return status;
	}

}
