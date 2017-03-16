package algorithm.constructive;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/new-year-chaos
 */

public class NewYearChaos {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for (int t_i = 0; t_i < t; t_i++) {
	        int n = in.nextInt();
	        int[] a = new int[n];
	        for(int n_i = 0; n_i < n; n_i++) {
	            a[n_i] = in.nextInt();
	        }
	        
	        if (isTooChaotic(a)) {
	        	System.out.println("Too Chaotic");
	        } else {
	        	System.out.println(findTotalBribe(a));
	        }
		}
		
        in.close();
    }
	
	private static int findTotalBribe(int[] a) {
		int totalBribe = 0;
		
		while (!isArraySorted(a)) {
			for (int i = 0; i < a.length - 1; i++) {
				if(a[i] > a[i + 1]){
	                int temp = a[i];
	                a[i] = a[i + 1];
	                a[i+1] = temp;
	                totalBribe++;
	            }
			}
		}
		
		return totalBribe;
	}
    
    private static boolean isTooChaotic(int[] a) {
    	
        for (int i = 0; i < a.length; i++) {
            if (a[i] > (i + 3)) {
                return true;
            }
        }
        
        return false;
    }
	
    private static boolean isArraySorted(int[] a) {
        for (int i = 0; i < (a.length - 1); i++) {
            if(a[i] > a[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
	
}
