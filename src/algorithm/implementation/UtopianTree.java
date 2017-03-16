package algorithm.implementation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/utopian-tree
 */

public class UtopianTree {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int i = 0; i < t; i++) {
        	
        	int n = in.nextInt();
        	int height = 1;
        	
        	if (n == 0) {
        		System.out.println(height);
        	} else {
        		for (int j = 0; j < n; j++) {
            		if (j % 2 == 0) {
            			height = height * 2;
            		} else {
            			height = height + 1;
            		}
            	}
        		
        		System.out.println(height);
        	}
        }
        in.close();
	}
}
