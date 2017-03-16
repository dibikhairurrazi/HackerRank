package algorithm.dynamicProgramming;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/unbounded-knapsack
 */

public class Knapsack {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int totalTestCase = in.nextInt();
		int[] results = new int[totalTestCase];
		
		for (int i = 0; i < totalTestCase; i++) {
			int[] data = new int[2];
			
			for (int j = 0; j < 2; j++) {
				data[j] = in.nextInt();
			}
			
			int totalItem = data[0];
			int maxWeight = data[1];

			int[] weight = new int[totalItem];
			
			for (int j = 0; j < data[0]; j++) {
				weight[j] = in.nextInt();
			}

			int res = getMaxWeight(maxWeight, totalItem - 1, weight);
			
			results[i] = res;
		}
		
		for (int res : results) {
			System.out.println(res);
		}
		
		in.close();
	}
    
    private static int getMaxWeight(int k, int n, int[] weights) {
    	
    	if (weights == null || weights.length == 0) {
    		return 0;
    	} else if (n < 0) {
    		return 0;
    	} else {
    		if (k >= weights[n]) {
    			return Math.max(getMaxWeight(k - weights[n], n, weights) + weights[n], getMaxWeight(k, n - 1, weights));
    		} else {
    			return getMaxWeight(k, n - 1, weights);
    		}
    	}
    }
	
}
