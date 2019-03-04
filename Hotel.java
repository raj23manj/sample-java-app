import java.util.List;
import java.util.Map;

import components.Controller;
import floors.Floor;
import utils.FileReader;
import utils.PowerConsumption;

public class Hotel {
	public static void main(String args[]) {
		Controller ctrl = new Controller();
		PowerConsumption powerConsumption = new PowerConsumption();

		FileReader fileReader = new FileReader();
		Map<Integer, Floor> floors = null;

		List<String> inputs = fileReader.readFile();

		for (Integer i = 0; i < inputs.size(); i++) {
			System.out.println("Input Value: " + inputs.get(i) + "\n");
			if (i == 0) {
				// the first line is the hotel initialization
				floors = ctrl.initialize(inputs.get(i));

			} else {
				// the rest of the lines are inputs from motion sensor detected output
				floors = ctrl.updateStates(inputs.get(i), floors);
			}
			ctrl.displayFloorStatus(floors);
			powerConsumption.calculatePowerConsumption(floors);
			System.out.println("####################################" + "\n");
		}
	}

}
