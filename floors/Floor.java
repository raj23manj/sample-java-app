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
	
	public Integer totalPowerConsumed(Integer floorNumber) {
		Integer totalConsumption = 0;		
		totalConsumption = corridorPowerConsumption(mainCorridors, totalConsumption);
		totalConsumption = corridorPowerConsumption(subCorridors, totalConsumption);		
		System.out.println("total power Consumed on floor" + floorNumber + " : " + totalConsumption + "\n");	
		checkConsumptionExceeded(totalConsumption);		
		return totalConsumption;
	}
	
	private void checkConsumptionExceeded(Integer consumed) {
		Integer mainCorridor = (mainCorridors.size() * Constants.MAIN_CORRIDOR_CALC);
		Integer subCorridor = (subCorridors.size() * Constants.SUB_CORRIDOR_CALC);
		Integer total = mainCorridor + subCorridor;
		
		if(consumed > total) {
			System.out.println("Power Consumed on this floor is Over the speicifed Units of " + total + "\n");
		}
	}
	
	private Integer corridorPowerConsumption(Map<Integer, Operatable> corridors, Integer totalConsumption) {
		
		for(Map.Entry<Integer, Operatable> corridor : corridors.entrySet()) {
			totalConsumption += corridor.getValue().devicePowerConsumption();
		}
		
		return totalConsumption;
	}
}
