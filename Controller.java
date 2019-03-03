import java.util.HashMap;
import java.util.Map;

import components.AC;
import components.Corridor;
import components.Device;
import components.Floor;
import components.Formatter;
import components.Light;
import components.MainCorridor;
import components.Message;
import components.Operatable;

public class Controller {
	public Map<Integer, Floor> initialize(String input) {
		Map<Integer, Floor> floors = new HashMap<>();
		
		String[] inputArr = input.split(" - ");
		
		Integer floorsCnt = Integer.valueOf(inputArr[0]);
		Integer mainCorridorCnt = Integer.valueOf(inputArr[1]);
		Integer subCorridorCnt = Integer.valueOf(inputArr[2]);
		
		for(Integer i=1; i<=floorsCnt; i++) {		
			Map<Integer, Operatable> mainCorridors = this.intializeCorridors(mainCorridorCnt);
			Map<Integer, Operatable> subCorridors = this.intializeCorridors(subCorridorCnt);		
			Formatter formatter = new Message();
			Floor floor = new Floor(mainCorridors, subCorridors, formatter);
			floors.put(i, floor);
		}
		
		return floors;

	}
	
	private Map<Integer, Operatable> intializeCorridors(Integer corridorCount) {
		Map<Integer, Operatable> corridors = new HashMap<>();
		for(Integer j=1; j<=corridorCount; j++) {
			
			Device lightCorridor = new Light();
			Device acCorridor = new AC();

			lightCorridor.turnOn();
			acCorridor.turnOn();
				
			Corridor corridor = new MainCorridor(lightCorridor, acCorridor);
			corridors.put(j, corridor);
		}
		return corridors;
	}
}
