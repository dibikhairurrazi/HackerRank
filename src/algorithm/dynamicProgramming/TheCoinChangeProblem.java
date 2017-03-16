package algorithm.dynamicProgramming;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/coin-change
 */

public class TheCoinChangeProblem {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        
		int n = in.nextInt();
		int m = in.nextInt();
		int c[] = new int[m];
		for (int i = 0; i < m; i++) {
			c[i] = in.nextInt();
		}
		
		System.out.println(count(c, m, n));
        
        in.close();
    }
	
	static long count(int []c, int m, int n) {
        
		long t[][] = new long[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
        	t[i][0] = 1; 
        }
            
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j < c[i - 1]) {
                    t[i][j] = t[i - 1][j];
                } else {
                    t[i][j] = t[i-1][j] + t[i][j-c[i-1]];            
                }
            }
        }
        
        return t[m][n];        
    }
}
