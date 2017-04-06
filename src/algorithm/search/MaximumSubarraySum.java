package algorithm.search;

import java.util.Scanner;

public class MaximumSubarraySum {

	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int i = 0; i < t; i++) {
        	int n = in.nextInt();
        	int m = in.nextInt();
        	int[] arr = new int[n];
        	
        	for (int j = 0; j < n; j++) {
        		arr[j] = in.nextInt();
        	}
        	
        	int res = maxSubArraySum(arr, m);
        	
        	System.out.println(res);
        }
        
        in.close();
    }
 
    static int maxSubArraySum(int a[], int m) {
    	
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
 
        for (int i = 0; i < size; i++)
        {
            max_ending_here = (max_ending_here + a[i]) % m;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        
        return max_so_far;
    }
    
    public static String kadaneAlgorithm(int[] ar, int m) {
		int maxEndingHere = 0;
		int maxSoFar = 0;
		int maxResult = 0;
		
		boolean allNegative = true;
		
		for (int i : ar) {
			maxEndingHere = Math.max(0, (maxEndingHere + i) % m);
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
