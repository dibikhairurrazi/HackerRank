package algorithm.implementation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/strange-code
 */

public class StrangeCounter {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        
        long remaining = 3;
        
        while (n > remaining) {
        	n = n - remaining;
        	remaining = remaining * 2;
        }
        
        System.out.println(remaining - n + 1);
        
        in.close();
	}
	
}
