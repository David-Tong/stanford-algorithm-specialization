package io.ytong.stanfordalgorithm.c1w1;

import java.math.BigInteger;

public class BigIntegerHelper {
	public String add(String num1, String num2) {
		BigInteger int1 = new BigInteger(num1);
		BigInteger int2 = new BigInteger(num2);
		return int1.add(int2).toString();
	}
	
	public String sub(String num1, String num2) {
		BigInteger int1 = new BigInteger(num1);
		BigInteger int2 = new BigInteger(num2);
		return int1.subtract(int2).toString();
	}
	
	public String multiply(String num1, String num2) throws Exception {
		if (num1.length() > 1) {
			throw new Exception();
		}
		
		BigInteger int1 = new BigInteger(num1);
		BigInteger int2 = new BigInteger(num2);
		return int1.multiply(int2).toString();
	}
}
