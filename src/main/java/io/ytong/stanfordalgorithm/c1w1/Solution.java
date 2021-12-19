package io.ytong.stanfordalgorithm.c1w1;

public class Solution {
	private Helper helper = new Helper();

	public String multiply(String num1, String num2) throws Exception {
		String result = "";
		for(int j=num2.length()-1; j>=0; j--) {
			char ch = num2.charAt(j);
			String temp = helper.stringMultiply(String.valueOf(ch), num1);
			int padding = num2.length() - j;
			for (int i=1; i<padding; i++) {
				temp += "0";
			}
			result = helper.stringAdd(result, temp);
		}
		return result;
	}
}
