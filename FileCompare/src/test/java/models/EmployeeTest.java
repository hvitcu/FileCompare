package models;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import models.Employee;

public class EmployeeTest {
	private static final String NAME = "Jane";
	private static final int AGE = 41;
	private static final String JOB_TITLE = "Project Manager";
	private static final LocalDate START_DATE = LocalDate.parse("2010-07-19");
	private Employee testEmpl;
	private static final Logger logger = Logger.getLogger(EmployeeTest.class.getName());

	@BeforeClass
	public void setupTestClass() {
		testEmpl = new Employee(NAME, AGE, JOB_TITLE, START_DATE);
	}
	
	@Test
	public void testGetName() {
		Assert.assertEquals(testEmpl.getName(), NAME);
		logger.log(Level.INFO, "Testing Employee Name");
	}
	
	@Test
	public void testGetAge() {
		Assert.assertEquals(testEmpl.getAge(), AGE);
		logger.log(Level.INFO, "Testing Employee Age");
	}
	
	@Test
	public void testGetJobTitle() {
		Assert.assertEquals(testEmpl.getJobTitle(), JOB_TITLE);
		logger.log(Level.INFO, "Testing Employee Job Title");
	}
	
	@Test
	public void testGetJobStartDate() {
		Assert.assertEquals(testEmpl.getStartDate(), START_DATE);
		logger.log(Level.INFO, "Testing Employee Start Date");
	}
	
	@Test
    public void testEqualsAndHashCode()
    {
        EqualsVerifier.forClass( Employee.class )
                .suppress( Warning.NONFINAL_FIELDS, Warning.NULL_FIELDS )
                .verify();
    }
}
