package io.ytong.stanfordalgorithm.c1w1;

public class Helper {
	public String stringAdd(String num1, String num2) {
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		
		String result = "";
		int carry = 0;
		while (i >= 0 && j >= 0) {
			char ch1 = num1.charAt(i);
			char ch2 = num2.charAt(j);
			int digital1 = Character.getNumericValue(ch1);
			int digital2 = Character.getNumericValue(ch2);
			int addition = digital1 + digital2 + carry;
			if (addition >= 10) {
				addition -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			result = String.valueOf(addition) + result;
			i--;
			j--;
		}
		
		while (i >= 0) {
			char ch1 = num1.charAt(i);
			int digital1 = Character.getNumericValue(ch1);
			int addition = digital1 + carry;
			if (addition >= 10) {
				addition -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			result = String.valueOf(addition) + result;
			i--;
		}
		
		while (j >= 0) {
			char ch2 = num2.charAt(j);
			int digital2 = Character.getNumericValue(ch2);
			int addition = digital2 + carry;
			if (addition >= 10) {
				addition -= 10;
				carry = 1;
			} else {
				carry = 0;
			}
			result = String.valueOf(addition) + result;
			j--;
		}
		
		if (carry != 0) {
			result = String.valueOf(carry) + result;
		}
		
		return result;
	}
	
	public String stringMultiply(String num1, String num2) throws Exception {
		if (num1.length() > 1) {
			throw new Exception();
		}
			
		int number = Integer.parseInt(num1);	
		String result = "";
		int carry = 0;
		
		for (int i = num2.length() - 1; i >= 0; i--) {
			char ch = num2.charAt(i);
			int digital = Character.getNumericValue(ch);
			int product = number * digital;	
			int residue = product % 10 + carry;
			carry = product / 10;
			if (residue >= 10) {
				residue -= 10;
				carry += 1;
			}
			result = String.valueOf(residue) + result;	
		}
		
		if (carry != 0) {
			result = String.valueOf(carry) + result;
		}
		
		return result;
	}
}
