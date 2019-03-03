import java.util.HashMap;
import java.util.Map;

import components.AC;
import components.Corridor;
import components.Device;
import components.Floor;
import components.Light;
import components.MainCorridor;
import components.Operatable;
import components.SubCorridor;

public class Hotel {
	public static void main(String args[]) {
		Map<Integer, Floor> floors = new HashMap<>();
		
		
		Device lightMainCorridor = new Light();
		Device acMainCorridor = new AC();
		
		lightMainCorridor.turnOn();
		acMainCorridor.turnOn();
		
		Device lightSubCorridor1 = new Light();
		Device acSubCorridor1 = new AC();
		
		lightSubCorridor1.turnOn();
		acSubCorridor1.turnOn();
		
		Device lightSubCorridor2 = new Light();
		Device acSubCorridor2 = new AC();
		
		lightSubCorridor2.turnOn();
		acSubCorridor2.turnOn();
		
		Map<Integer, Operatable> mainCorridors = new HashMap<>();
		Corridor mainCorridor = new MainCorridor(lightMainCorridor, acMainCorridor);
		mainCorridors.put(1, mainCorridor);
		
		Corridor subCorridor1 = new SubCorridor(lightSubCorridor1, acSubCorridor1);
		Corridor subCorridor2 = new SubCorridor(lightSubCorridor2, acSubCorridor2);
		
		Map<Integer, Operatable> subCorridors = new HashMap<>();
		subCorridors.put(1, subCorridor1);
		subCorridors.put(2, subCorridor2);
		
		// First Floor
		Floor floor1 = new Floor(mainCorridors, subCorridors);
		floors.put(1, floor1);
		
		floors.forEach((k,v) -> {
			System.out.println(v.getStatus(k));
		});
		
		//
		
	}
}
