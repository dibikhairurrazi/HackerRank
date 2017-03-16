package algorithm.implementation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/apple-and-orange
 */

public class AppleAndOranges {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i=0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i=0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        
        int apples = 0;
        int oranges = 0;
        
        for (int ap : apple) {
        	if ((a + ap >= s) && (a + ap <= t)) {
        		apples++;
        	}
        }
        
        for (int or : orange) {
        	if ((b + or >= s) && (b + or <= t)) {
        		oranges++;
        	}
        }
        
        System.out.println(apples);
        System.out.println(oranges);
        
        in.close();
    }
	
}
