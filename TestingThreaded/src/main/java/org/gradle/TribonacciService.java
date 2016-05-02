package org.gradle;

import java.math.BigInteger;

public interface TribonacciService {
	
	/**
	* Calculates tribonacci numbers recursively
	* @param n
	* @return The nth tribonacci number
	*/
	public BigInteger getTribonacciRecursive(int n);
	/**
	* Calculates tribonacci numbers iteratively
	* @param n
	* @return The nth tribonacci number
	*/
	public BigInteger getTribonacciIterative(int n);
	
}
