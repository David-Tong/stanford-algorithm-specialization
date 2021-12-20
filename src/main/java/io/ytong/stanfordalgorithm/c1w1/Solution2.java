package io.ytong.stanfordalgorithm.c1w1;

// Karatsuba Multiply
public class Solution2 {
	private BigIntegerHelper helper = new BigIntegerHelper();
	
	public String multiply(String num1, String num2) {
		try {
			return doMultiply(num1, num2);
		} catch (Exception e) {
			e.printStackTrace();
			return "Error happened!";
		}
	}
	
	// part 1 - a * c
	// part 3 - b * d
	// part 2 - (a + b) * (c + d) - (a * c + b * d)
	public String doMultiply(String num1, String num2) throws Exception {
		String result = "";
		if (num1.length() == 1) {
			result = helper.multiply(num1, num2);
		} else if (num2.length() == 1) {
			result = helper.multiply(num2, num1);
		} else {
			int padding = 0;
			int lenDiff = Math.max(num1.length(), num2.length()) - Math.min(num1.length(), num2.length());
			if (num1.length() < num2.length()) {
				for (int i=0; i<lenDiff; i++) {
					num1 += "0";
					padding++;
				}
			} else if (num1.length() > num2.length()) {
				for (int i=0; i<lenDiff; i++) {
					num2 += "0";
					padding++;
				}
			}
			
			int num1Half = num1.length() / 2;
			int num2Half = num2.length() / 2;
			String a = num1.substring(0, num1Half);
			String b = num1.substring(num1Half);
			String c = num2.substring(0, num2Half);
			String d = num2.substring(num2Half);
			
			String part1 = this.doMultiply(a, c);
			String part3 = this.doMultiply(b, d);
			String part2 = this.doMultiply(helper.add(a, b), helper.add(c, d)); 
			part2 = helper.sub(part2, part1);
			part2 = helper.sub(part2, part3);
			
			int adjust = num1.length() - num1Half;
			for (int i = 0; i < adjust * 2; i++) {
				part1 += "0";
			}
			for (int i = 0; i < adjust; i++) {
				part2 += "0";
			}
			
			result = helper.add(part1, part2);
			result = helper.add(result, part3);
			result = result.substring(0, result.length() - padding);
		}
		
		return result;
	}
}
