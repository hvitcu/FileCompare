package org.gradle;

import static org.testng.Assert.assertEquals;

import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TribonacciTest {

	private TribonacciImplementation testClass;
	private static final Logger logger = Logger.getLogger(TribonacciTest.class.getName());

	@BeforeClass
	public void setupBeforeTest() {
		testClass = new TribonacciImplementation();
	}

	@Test
	public void testGetTribonacciRecursiveReturnsFirstElementWhichIs_0() {
		assertEquals(BigInteger.valueOf(0), testClass.getTribonacciRecursive(0));
		logger.log(Level.INFO, 
				"Tribonacci Recursive returns first element should be 0");
	}

	@Test
	public void testGetTribonacciRecursiveReturnsSecondElementWhichIs_0() {
		assertEquals(BigInteger.valueOf(0), testClass.getTribonacciRecursive(1));
		logger.log(Level.INFO, 
				"Tribonacci Recursive returns second element should be 0");
	}

	@Test
	public void testGetTribonacciRecursiveReturnsThirdElementWhichIs_1() {
		assertEquals(BigInteger.valueOf(1), testClass.getTribonacciRecursive(2));
		logger.log(Level.INFO, 
				"Tribonacci Recursive returns third element should be 1");
	}

	@Test
	public void testGetTribonacciRecursiveReturnsFourthElementWhichIs_1() {
		assertEquals(BigInteger.valueOf(1), testClass.getTribonacciRecursive(3));
		logger.log(Level.INFO, 
				"Tribonacci Recursive returns fourth element should be 1");
	}

	@Test
	public void testGetTribonacciRecursiveReturnsFithElementWhichIs_2() {
		assertEquals(BigInteger.valueOf(2), testClass.getTribonacciRecursive(4));
		logger.log(Level.INFO, 
				"Tribonacci Recursive returns fith element should be 2");
	}

	@Test
	public void testGetTribonacciRecursiveReturnsTenthElementWhichIs_81() {
		assertEquals(BigInteger.valueOf(81), testClass.getTribonacciRecursive(10));
		logger.log(Level.INFO, 
				"Tribonacci Recursive returns tenth element should be 81");
	}

	@Test
	public void testGetTribonacciRecursiveReturnsTwentyFithElementWhichIs_755476() {
		assertEquals(BigInteger.valueOf(755476), testClass.getTribonacciRecursive(25));
		logger.log(Level.INFO, 
				"Tribonacci Recursive returns twentyfith element should be 755476");
	}

	@Test
	public void testGetTribonacciIterativeReturnsFirstElementWhichIs_0() {
		assertEquals(BigInteger.valueOf(0), testClass.getTribonacciIterative(0));
		logger.log(Level.INFO, 
				"Tribonacci Iterative returns first element should be 0");
	}

	@Test
	public void testGetTribonacciIterativeReturnsSecondElementWhichIs_0() {
		assertEquals(BigInteger.valueOf(0), testClass.getTribonacciIterative(1));
		logger.log(Level.INFO, 
				"Tribonacci Iterative returns second element should be 0");
	}

	@Test
	public void testGetTribonacciIterativeReturnsThirdElementWhichIs_1() {
		assertEquals(BigInteger.valueOf(1), testClass.getTribonacciIterative(2));
		logger.log(Level.INFO, 
				"Tribonacci Iterative returns third element should be 1");
	}

	@Test
	public void testGetTribonacciIterativeReturnsFourthElementWhichIs_1() {
		assertEquals(BigInteger.valueOf(1), testClass.getTribonacciIterative(3));
		logger.log(Level.INFO, 
				"Tribonacci Iterative returns fourth element should be 1");
	}

	@Test
	public void testGetTribonacciIterativeReturnsFithElementWhichIs_2() {
		assertEquals(BigInteger.valueOf(2), testClass.getTribonacciIterative(4));
		logger.log(Level.INFO, 
				"Tribonacci Iterative returns fith element should be 2");
	}

	@Test
	public void testGetTribonacciIterativeReturnsTenthElementWhichIs_81() {
		assertEquals(BigInteger.valueOf(81), testClass.getTribonacciIterative(10));
		logger.log(Level.INFO, 
				"Tribonacci Iterative returns tenth element should be 81");
	}

	@Test
	public void testGetTribonacciIterativeReturnsTwentyFithElementWhichIs_755476() {
		assertEquals(BigInteger.valueOf(755476), testClass.getTribonacciIterative(25));
		logger.log(Level.INFO, 
				"Tribonacci Iterative returns twentyfith element should be 755476");
	}
}
