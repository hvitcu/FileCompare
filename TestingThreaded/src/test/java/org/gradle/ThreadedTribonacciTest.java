package org.gradle;

import static org.testng.Assert.assertEquals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class ThreadedTribonacciTest {

	@Test
	public void testThreaded() throws InterruptedException, ExecutionException, TimeoutException {
		TribonacciImplementation test = new TribonacciImplementation();

		List<BigInteger> expectedNumbers = new ArrayList<>();
		expectedNumbers.add(BigInteger.valueOf(2));
		expectedNumbers.add(BigInteger.valueOf(81));
		expectedNumbers.add(BigInteger.valueOf(755476));

		List<Callable<BigInteger>> tasks = Arrays.asList(createTask(4, test), createTask(10, test),
				createTask(25, test));

		ExecutorService executor = Executors.newWorkStealingPool();
		List<BigInteger> results = executor.invokeAll(tasks)
				.parallelStream().map(future -> {
			try {
				return future.get();
			} catch (Exception e) {
				throw new IllegalStateException(e);
			}
		}).collect(Collectors.toList());

		for (int i = 0; i < expectedNumbers.size(); i++) {
			assertEquals(expectedNumbers.get(i), results.get(i));
		}
	}

	private Callable<BigInteger> createTask(int nth, TribonacciImplementation test) {
		Callable<BigInteger> taskOne = () -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				return test.getTribonacciIterative(nth);
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};
		return taskOne;
	}

}
