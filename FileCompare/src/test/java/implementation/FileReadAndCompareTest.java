package implementation;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import models.Employee;
import utils.FileDelimiter;

public class FileReadAndCompareTest {

	private FileReadAndCompare testClass = null;
	private static final String RESOURCE_CSV = "..\\sample_files\\the_csv_file.csv";
	private static final String RESOURCE_PIPE = "..\\sample_files\\the_pipe_file.txt";

	private static final String EMPLOYEE_NAME = "Jane";
	private static final int AGE = 41;
	private static final String JOB_TITLE = "Project Manager";
	private static final LocalDate START_DATE = LocalDate.parse("2010-07-19");
	private Employee testEmpl;
	private File csvFile = null;
	private File pipeFile = null;

	@BeforeClass
	public void setupTestClass() throws URISyntaxException {
		testEmpl = new Employee(EMPLOYEE_NAME, AGE, JOB_TITLE, START_DATE);
		testClass = new FileReadAndCompare();
		URI csvURI = FileReadAndCompareTest.class.getResource(RESOURCE_CSV).toURI();
		URI pipeURI = FileReadAndCompareTest.class.getResource(RESOURCE_PIPE).toURI();
		csvFile = new File(csvURI);
		pipeFile = new File(pipeURI);
	}

	@Test
	public void testFileReadCSVReturnsMap() throws IOException, URISyntaxException {
		Map<Integer, Employee> fileAsMap = getFileAsMap(csvFile,
				FileDelimiter.CSV_FILE.getDelimiter());
		
		Employee expected = fileAsMap.get(5);
		Assert.assertEquals(testEmpl, expected);
	}

	@Test
	public void testFileReadPIPEReturnsMap() throws IOException, URISyntaxException {
		Map<Integer, Employee> fileAsMap = getFileAsMap(pipeFile,
				FileDelimiter.PIPE_FILE.getDelimiter());
		
		Employee expected = fileAsMap.get(5);
		Assert.assertEquals(testEmpl, expected);
	}

	@Test
	public void testFileReadCompareFilesCSVDifferent() throws URISyntaxException, IOException {
		Map<Integer, Employee> fileAsMapCSV = getFileAsMap(csvFile,
				FileDelimiter.CSV_FILE.getDelimiter());
		Map<Integer, Employee> fileAsMapPIPE = getFileAsMap(pipeFile,
				FileDelimiter.PIPE_FILE.getDelimiter());
		
		fileAsMapCSV.remove(5);
		List<Employee> differences = testClass.compareFilesContents(fileAsMapCSV, fileAsMapPIPE);

		Assert.assertTrue(differences.contains(testEmpl));

	}
	
	private Map<Integer, Employee> getFileAsMap(File file, String delimiterType)
			throws URISyntaxException, IOException {
		Map<Integer, Employee> fileAsMap = testClass.getFileAsMap(file, delimiterType);
		return fileAsMap;
	}

	@Test
	public void testFileReadCompareFilesPIPEDifferent() throws URISyntaxException, IOException {
		Map<Integer, Employee> fileAsMapCSV = getFileAsMap(csvFile,
				FileDelimiter.CSV_FILE.getDelimiter());
		Map<Integer, Employee> fileAsMapPIPE = getFileAsMap(pipeFile,
				FileDelimiter.PIPE_FILE.getDelimiter());
		
		fileAsMapPIPE.remove(5);
		List<Employee> differences = testClass.compareFilesContents(fileAsMapCSV, fileAsMapPIPE);

		Assert.assertTrue(differences.contains(testEmpl));

	}

	@Test
	public void testFileReadCompareFilesNoDifferences() throws URISyntaxException, IOException {
		Map<Integer, Employee> fileAsMapCSV = getFileAsMap(csvFile,
				FileDelimiter.CSV_FILE.getDelimiter());
		Map<Integer, Employee> fileAsMapPIPE = getFileAsMap(pipeFile,
				FileDelimiter.PIPE_FILE.getDelimiter());
		List<Employee> differences = testClass.compareFilesContents(fileAsMapCSV, fileAsMapPIPE);
		Assert.assertEquals(0, differences.size());
	}
	
	@Test(expectedExceptions = IOException.class)
	public void testGetFileAsMapThrowsIOException() throws URISyntaxException, IOException {
		testClass.getFileAsMap(null, ",");
	}
	

	@Test
	public void testGetFileAsMapNullFile() throws URISyntaxException, IOException {
		URI empty = FileReadAndCompareTest.class.getResource("..\\sample_files\\empty.csv").toURI();
		testClass.getFileAsMap(new File(empty), ",");
	}
	
}