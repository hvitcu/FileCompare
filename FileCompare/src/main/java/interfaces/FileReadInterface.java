package interfaces;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.NoSuchFileException;
import java.util.Map;

import models.Employee;

public interface FileReadInterface {
	/**
	 * Returns contents of file as a map 
	 * 
	 * @param fileLocation The file
	 * @param delimiterType The type of delimiter for the file
	 * 
	 * @return Map where key is the index and the value is the row
	 * 
	 * @throws NoSuchFileException 
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	Map<Integer, Employee> getFileAsMap(File file, String delimiterType) throws NoSuchFileException, IOException;
}
