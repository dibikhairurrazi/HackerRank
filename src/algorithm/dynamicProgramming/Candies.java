package algorithm.dynamicProgramming;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/candies
 */

public class Candies {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        
        int[] candy = new int[n];
        
        if (a[0] <= a[1]) {
        	candy[0] = 1;
        }
        
        if (a[n - 1] <= a[n - 2]) {
        	candy[n - 1] = 1;
        }
        
        if (a[0] > a[1]) {
        	candy[0] = getCandy(a, candy, 1) + 1;
        }
        
        if (a[n - 1] > a[n - 2]) {
        	candy[n - 1] = getCandy(a, candy, n - 2) + 1;
        }
        
        for (int i = 1; i < (n - 1); i++) {
            if (candy[i] == 0) {
            	candy[i] = getCandy(a, candy, i);
            }
        }
        
        long result = 0;
     
        for(int r : candy){
            result = result + r;
        }
        
        System.out.println(result);
	    
	    in.close();
	}
	
	public static int getCandy(int[] a, int[] candy, int i) {
		if ((a[i] <= a[i - 1]) && (a[i] <= a[i + 1])) {
			return 1;
		}
		
		if((a[i] > a[i - 1]) && (a[i] <= a[i + 1])){
	        if(candy[i-1] == 0) {
	        	candy[i-1] = getCandy(a,candy,i-1);
	        }
	        
	        return 1 + candy[i-1];
	    }
		
	    if((a[i] > a[i + 1]) && (a[i] <= a[i - 1])){
	        if(candy[i + 1] == 0) {
	        	candy[i + 1] = getCandy(a, candy, i + 1);
	        }
	        
	        return 1 + candy[i + 1];
	    }
	    
	    if((a[i] > a[i + 1]) && (a[i] > a[i - 1])){
	        if(candy[i - 1] == 0) {
	        	candy[i-1] = getCandy(a, candy, i - 1);
	        }
	        
	        if(candy[i + 1] == 0) {
	        	candy[i + 1] = getCandy(a, candy, i + 1);
	        }
	        
	        return 1 + (candy[i - 1] > candy[i + 1] ? candy[i - 1] : candy[i + 1]);
	    }
		
		return 0;
	}
}
