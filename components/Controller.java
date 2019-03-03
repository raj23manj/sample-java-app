package components;

import java.util.HashMap;
import java.util.Map;

public class Controller {
	public Map<Integer, Floor> initialize(String input) {
		Map<Integer, Floor> floors = new HashMap<>();

		String[] inputArr = splitString(input);

		Integer floorsCnt = Integer.valueOf(inputArr[0]);
		Integer mainCorridorCnt = Integer.valueOf(inputArr[1]);
		Integer subCorridorCnt = Integer.valueOf(inputArr[2]);

		for (Integer i = 1; i <= floorsCnt; i++) {
			Map<Integer, Operatable> mainCorridors = this.intializeCorridors(mainCorridorCnt, Constants.MAIN);
			Map<Integer, Operatable> subCorridors = this.intializeCorridors(subCorridorCnt, Constants.SUB);
			Formatter formatter = new Message();
			Floor floor = new Floor(mainCorridors, subCorridors, formatter);
			floors.put(i, floor);
		}

		return floors;

	}

	public void displayFloorStatus(Map<Integer, Floor> floors) {
		// outputting each floor status for default
		floors.forEach((k, v) -> {
			System.out.println(v.getStatus(k));
		});
	}

	public Map<Integer, Floor> updateStates(String input, Map<Integer, Floor> floors) {

		String[] inputArr = splitString(input);
		Boolean movement = Boolean.valueOf(inputArr[0]);
		Integer floorNumber = Integer.valueOf(inputArr[1]);
		String corridorType = inputArr[2];
		Integer corridorNumber = Integer.valueOf(inputArr[3]);

		Floor currentFloor = null;
		Operatable currentCorridor = null;

		// get which floor
		currentFloor = floors.get(floorNumber);
		Map<Integer, Operatable> corridors = currentFloor.getCorridor(corridorType);

		if (movement == true) {
			// set state to off of ac's
			for (Map.Entry<Integer, Operatable> corridor : corridors.entrySet()) {
				corridor.getValue().acOff();
			}
			// get which corridor
			currentCorridor = corridors.get(corridorNumber);
			currentCorridor.lightOn();
			currentCorridor.acOn();
		} else {

			// set state to on of ac's
			for (Map.Entry<Integer, Operatable> corridor : corridors.entrySet()) {
				corridor.getValue().acOn();
			}
			// get which corridor
			currentCorridor = corridors.get(corridorNumber);
			currentCorridor.lightOff();

		}

		return floors;
	}

	private String[] splitString(String s) {
		return s.split(" - ");
	}

	private Map<Integer, Operatable> intializeCorridors(Integer corridorCount, String type) {
		Map<Integer, Operatable> corridors = new HashMap<>();
		for (Integer j = 1; j <= corridorCount; j++) {

			Device lightCorridor = new Light();
			Device acCorridor = new AC();

			acCorridor.turnOn();
			if (type == Constants.MAIN) {
				lightCorridor.turnOn();
			} else {
				lightCorridor.turnOff();
			}

			Corridor corridor = new MainCorridor(lightCorridor, acCorridor);
			corridors.put(j, corridor);
		}
		return corridors;
	}

}
