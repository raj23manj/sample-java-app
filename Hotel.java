import java.util.List;
import java.util.Map;

import components.Floor;

public class Hotel {
	public static void main(String args[]) {
		Controller ctrl = new Controller();
		
		FileReader fileReader = new FileReader();
		
		List<String> inputs = fileReader.readFile();
		System.out.println("inputs: " + inputs);
		
		Map<Integer, Floor> floors = ctrl.initialize();
		
		floors.forEach((k, v) -> {
			System.out.println(v.getStatus(k));
		});
	}
}
