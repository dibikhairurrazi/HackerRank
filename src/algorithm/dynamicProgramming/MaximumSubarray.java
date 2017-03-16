package algorithm.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/maxsubarray
 */

public class MaximumSubarray {
	
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		List<String> results = new ArrayList<String>();
		int testCase = in.nextInt();
		
		for (int a = 0; a < testCase; a++) {
			int n = in.nextInt();
			
			int[] ar = new int[n];
			
			for(int i=0;i<n;i++) {
				ar[i]=in.nextInt(); 
			}
			
			String res = kadaneAlgorithm(ar);
			
			results.add(res);
		}
		
		for (String res : results) {
			System.out.println(res);
		}

		in.close();
	}
    
    public static String kadaneAlgorithm(int[] ar) {
		int maxEndingHere = 0;
		int maxSoFar = 0;
		int maxResult = 0;
		
		boolean allNegative = true;
		
		for (int i : ar) {
			maxEndingHere = Math.max(0, maxEndingHere + i);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
			
			if (i >= 0) {
				maxResult += i;
				allNegative = false;
			}
		}
		
		int comparator = -1000000000;
		
		if (allNegative) {
			for (int i : ar) {
				if (i > comparator) {
					comparator = i;
				}
			}
			
			maxSoFar = comparator;
			maxResult = comparator;
		}
		
		String result = maxSoFar + " " + maxResult;
		
		return result;
	}
	
}
