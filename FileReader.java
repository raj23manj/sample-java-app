import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	public List<String> readFile() {

		List<String> inputs = new ArrayList<>();

		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		System.out.println("Current relative path is: " + s + "\n");

		File file = new File(s + "/input.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (sc.hasNextLine()) {
			String readValue = sc.nextLine();
			System.out.println( readValue + "\n");
			inputs.add(readValue);
		}
		
		return inputs;
	}
}
