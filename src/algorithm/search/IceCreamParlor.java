package algorithm.search;

import java.util.Scanner;

public class IceCreamParlor {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int i = 0; i < t; i++) {
        	int m = in.nextInt();
        	int n = in.nextInt();
        	int[] arr = new int[n];
        	for (int arr_i = 0; arr_i < n; arr_i++) {
        		arr[arr_i] = in.nextInt();
        	}
        	
        	String answer = "";
        	int highest = 0;
        	
        	for (int j = 0; j < arr.length - 1; j++) {
        		for (int k = j + 1; k < arr.length; k++) {
        			
        			int total = arr[j] + arr[k];
        			
        			if ((total <= m) && (total > highest)) {
        				answer = (j + 1) + " " + (k + 1);
        				highest = total;
        			}
        		}
        	}
        	
        	System.out.println(answer);
        	
        }
        in.close();
    }
}
