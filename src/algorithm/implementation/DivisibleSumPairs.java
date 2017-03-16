package algorithm.implementation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/divisible-sum-pairs
 */

public class DivisibleSumPairs {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        
        int sum[][] = new int[n][n];
        int tot = 0;
        
        for (int i = 0; i < n; i++) {
        	for (int j = i + 1; j < n; j++) {
        		
        		int add = 0;
        		
        		if (sum[i][j] == 0) {
        			add = a[i] + a[j];
        			sum[i][j] = add;
        			sum[j][i] = add;
        			
        			if (add % k == 0) {
            			tot++;
            		}
        		}
        	}
        }
        
        System.out.println(tot);
        
        in.close();
    }
	
}
