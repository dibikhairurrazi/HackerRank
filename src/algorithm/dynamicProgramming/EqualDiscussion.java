package algorithm.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/equal
 */

public class EqualDiscussion {

	public static void main(String[] args) {
	    
		Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    
	    for (int i = 0; i < t; i++) {
	        
	    	int n = in.nextInt();
	        int arr[] = new int[n];
	        
	        for(int j = 0; j < n; j++){
	            arr[j] = in.nextInt();
	        }
	        
	        System.out.println(findMinimum(arr));
	    }
	    
	    in.close();
	}
	
	public static long findMinimum(int[] cookies) {

	    Arrays.sort(cookies);

	    long sum = Long.MAX_VALUE;

	    for (int base = 0; base < 3; base++) {
	        
	    	int current_sum = 0;
	        
	        for(int i = 0; i < cookies.length; i++) {
	            int delta = cookies[i] - cookies[0] + base;
	            current_sum += (int) delta / 5 + delta % 5 / 2 + delta % 5 % 2 / 1;
	        }
	        
	        sum = Math.min(current_sum, sum);
	    }

	    return sum;
	}
}
