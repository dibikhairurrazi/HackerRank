package algorithm.implementation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/bon-appetit
 */

public class BonAppetit {

	public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        	arr[i] = in.nextInt();
        }
        
        int charge = in.nextInt();
        int eaten = 0;
        
        for (int i = 0; i < n; i++) {
        	if (i != k) {
        		eaten = eaten + arr[i];
        	}
        }
        
        int overCharge = charge - (eaten / 2);
        
        if (overCharge == 0) {
        	System.out.println("Bon Appetit");
        } else {
        	System.out.println(overCharge);
        }
        
        in.close();
    }
	
}
