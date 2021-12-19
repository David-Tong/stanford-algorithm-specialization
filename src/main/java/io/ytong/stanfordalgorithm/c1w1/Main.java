package io.ytong.stanfordalgorithm.c1w1;

public class Main {

	public static void main(String[] args) {
		Solution solution = new Solution();
		try {
			String result = solution.multiply("3141592653589793238462643383279502884197169399375105820974944592", 
					"2718281828459045235360287471352662497757247093699959574966967627");
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
