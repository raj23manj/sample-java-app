import java.util.List;
import java.util.Map;

import components.Floor;

public class Hotel {
	public static void main(String args[]) {
		Controller ctrl = new Controller();

		FileReader fileReader = new FileReader();
		Map<Integer, Floor> floors = null;

		List<String> inputs = fileReader.readFile();

		for (Integer i = 0; i < inputs.size(); i++) {
			if (i == 0) {
				// the first line is the hotel initialization
				floors = ctrl.initialize(inputs.get(i));
			} else {
				
			}
		}

		floors.forEach((k, v) -> {
			System.out.println(v.getStatus(k));
		});
	}
}
