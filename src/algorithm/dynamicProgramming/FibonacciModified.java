package algorithm.dynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/fibonacci-modified
 */

public class FibonacciModified {

	/*
	 * Ti+2 = Ti + (Ti+1)^2
	 */
	
	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();

		String[] inputs = input.split(" ");
		int[] inputInt = new int[inputs.length];
		BigInteger[] memo = new BigInteger[20];
		
		for (int i = 0; i < inputs.length; i++) {
			inputInt[i] = Integer.parseInt(inputs[i]);
		}
		
		BigInteger a = BigInteger.valueOf(inputInt[0]);
		BigInteger b = BigInteger.valueOf(inputInt[1]);
		int n = inputInt[2] - 1;
		
		memo[0] = a;
		memo[1] = b;
		
		for (int i = 2; i < 20; i++) {
			memo[i] = BigInteger.valueOf(-1);
		}
		
		calculate(memo, n);
		
		System.out.println(memo[n]);
		
		scanner.close();
	}
	
	private static BigInteger calculate(BigInteger[] memo, int n) {
		if (memo[n].intValue() != -1) {
			return memo[n];
		} else {
			BigInteger fibonaci = (calculate(memo, n-1).pow(2)).add(calculate(memo, n - 2));
			memo[n] = fibonaci;
			return fibonaci;
		}
	}
}
