package floors;

import java.util.HashMap;
import java.util.Map;

import corridors.Operatable;
import utils.Constants;
import utils.Formatter;

public class Floor implements Status<String, Integer> {

	private Map<Integer, Operatable> mainCorridors;
	private Map<Integer, Operatable> subCorridors;
	private Map<String, Map<Integer, Operatable>> completeFloor = new HashMap<>();
	private Formatter formatter;

	public Floor(Map<Integer, Operatable> mainCorridors, Map<Integer, Operatable> subCorridors, Formatter formatter) {
		super();
		this.mainCorridors = mainCorridors;
		this.subCorridors = subCorridors;
		this.completeFloor.put(Constants.MAIN, mainCorridors);
		this.completeFloor.put(Constants.SUB, subCorridors);	
		this.formatter = formatter;
	}

	@Override
	public String getStatus(Integer floorNo) {
		String status = String.format(Constants.MESSAGE_1, floorNo);		
		status = formatter.setArgumentsAndFormat(status, mainCorridors, Constants.MAIN);
		status = formatter.setArgumentsAndFormat(status, subCorridors, Constants.SUB);		
		return status;
	}

	public  Map<Integer, Operatable> getCorridor(String type) {
		return this.completeFloor.get(type);
	}
	
}
