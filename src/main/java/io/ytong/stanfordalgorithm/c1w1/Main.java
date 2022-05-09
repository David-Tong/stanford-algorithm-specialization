package io.ytong.stanfordalgorithm.c1w1;

import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		try {
			String result = solution.multiply("3141592653589793238462643383279502884197169399375105820974944592", 
					"2718281828459045235360287471352662497757247093699959574966967627");
			System.out.println(result);
			
			BigInteger num1 = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
			BigInteger num2 = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
			String result2 = num1.multiply(num2).toString();
			System.out.println(result2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
