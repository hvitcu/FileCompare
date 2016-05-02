package implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.FileReadInterface;
import models.Employee;

public class FileReadAndCompare implements FileReadInterface {

	public Map<Integer, Employee> getFileAsMap(File file, String delimiterType) throws IOException {

		BufferedReader br = getBufferedReader(file);

		Map<Integer, Employee> employeesMap = new HashMap<>();
		
		String readLine = "";
		while (null != (readLine = br.readLine())) {
			if ("".equals(readLine))
				break;
			
			List<String> asList = Arrays.asList(readLine.split(delimiterType));

			String name = asList.get(1).trim();
			Integer age = Integer.valueOf(asList.get(2).trim());
			String job = asList.get(3).trim();
			LocalDate date = LocalDate.parse(asList.get(4).trim());

			employeesMap.put(Integer.valueOf(asList.get(0).trim()), new Employee(name, age, job, date));
		}
		br.close();
		return employeesMap;
	}

	private BufferedReader getBufferedReader(File file) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (Exception e) {
			throw new IOException(e);
		}
		return br;
	}

	public List<Employee> compareFilesContents(Map<Integer, Employee> fileAsMapOne,
			Map<Integer, Employee> fileAsMapTwo) {

		Collection<Employee> firstListEmpl = fileAsMapOne.values();
		Collection<Employee> secondListEmpl = fileAsMapTwo.values();

		List<Employee> diffList = new ArrayList<>();

		firstListEmpl.parallelStream().forEach(empl -> {
			if (!secondListEmpl.contains(empl)) {
				diffList.add(empl);
			}
		});

		secondListEmpl.parallelStream().forEach(empl -> {
			if (!firstListEmpl.contains(empl)) {
				diffList.add(empl);
			}
		});

		return diffList;
	}
}
