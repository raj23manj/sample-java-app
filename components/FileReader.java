package components;
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
		// get current relative path
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		// file to be read
		File file = new File(s + "/input.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		// reading file lines
		while (sc.hasNextLine()) {
			String readValue = sc.nextLine();
			inputs.add(readValue);
		}
		return inputs;
	}
}
