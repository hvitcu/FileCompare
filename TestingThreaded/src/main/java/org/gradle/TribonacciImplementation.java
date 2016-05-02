package org.gradle;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TribonacciImplementation implements TribonacciService{

	private BigInteger first = new BigInteger("0");
	private BigInteger second = new BigInteger("0");
	private BigInteger third = new BigInteger("1");
	private List<BigInteger> tribonacciList = null;	
	
	public TribonacciImplementation() {
		tribonacciList = Collections.synchronizedList(new ArrayList<BigInteger>());
		tribonacciList.add(first); 
		tribonacciList.add(second); 
		tribonacciList.add(third);
	}
	
	public BigInteger getTribonacciRecursive(int n) {
		
		recursivelyCalculateTribonacci(n);
		
		return tribonacciList.get(n);
	}

	private void recursivelyCalculateTribonacci(int n) {
		if (n == 0) {
			return;
		}
		else {
			createTribonacci();
			
			recursivelyCalculateTribonacci(--n);
		}
	}

	private synchronized void createTribonacci() {
		BigInteger sum = first.add(second).add(third);
		tribonacciList.add(sum);
		
		first = second;
		second = third;
		third = sum;
	}

	public BigInteger getTribonacciIterative(int n) {
		
		for (int i = 0; i < n; i++) {
			createTribonacci();
		}
		return tribonacciList.get(n);
	}
}
