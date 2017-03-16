package algorithm.implementation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/absolute-permutation
 */

public class AbsolutePermutation {

	public static void main(String[] args) {
	    
		Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    for(int a0 = 0; a0 < t; a0++){
	    	
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int[] res = solve(n,k);
	        
	        for(int i = 0 ; i < res.length ; ++i) {
	        	
	            System.out.print(res[i]);
	            
	            if( i != res.length) {
	            	System.out.print(" ");
	            }
	            
	        }
	        
	        System.out.println();
	        
	        in.close();
	    }
	}
	
	public static int[] solve(int n, int k) {
		
	    int[] result = new int[n];
	    
	    if (k == 0) {
	        
	    	for(int i = 0 ; i < n ; ++i) {
	            result[i] = i + 1;
	        }
	    	
	        return result;
	    }
	    
	    if (n%2 == 1) {
	    	return new int[]{-1};
	    }

	    if (n%k == 0 && (n/k)%2 == 0) {
	    	
	        int signSwitch = 1;
	        int counter = 0;
	        
	        for(int i = 0 ; i < n ; ++i) {
	            
	        	result[i+k*signSwitch] = i+1;
	            counter++;
	            
	            if ((counter/k)%2 == 1) {
	                signSwitch = -1;
	            } else {
	                signSwitch = 1;
	            }
	        }
	        
	    } else {
	        return new int[]{-1};
	    }
	    
	    return result;
	}
	
}
