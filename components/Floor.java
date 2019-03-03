package components;

import java.util.HashMap;
import java.util.Map;

public class Floor implements Status<String, Integer> {

	private Map<Integer, Operatable> mainCorridors;
	private Map<Integer, Operatable> subCorridors;
	private Map<String, Object> completeFloor = new HashMap<String, Object>();
	private Formatter formatter;

	public Floor(Map<Integer, Operatable> mainCorridor, Map<Integer, Operatable> subCorridors, Formatter formatter) {
		super();
		this.mainCorridors = mainCorridor;
		this.subCorridors = subCorridors;
		this.completeFloor.put(Constants.MAIN_CORRIDOR, mainCorridor);
		this.completeFloor.put(Constants.SUB_CORRIDOR, subCorridors);	
		this.formatter = formatter;
	}

	@Override
	public String getStatus(Integer floorNo) {
		String status = String.format(Constants.MESSAGE_1, floorNo);		
		status = formatter.setArgumentsAndFormat(status, mainCorridors, Constants.MAIN);
		status = formatter.setArgumentsAndFormat(status, subCorridors, Constants.SUB);		
		return status;
	}
}
