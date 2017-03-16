package algorithm.bitManipulation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/sum-vs-xor
 */

public class SumVsXor {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        
        long count = 0;
        int ch = 0;
        
        if (n == 0) {
        	System.out.println(1);
        } else {
        	String s = Long.toBinaryString(n);
            for (char c : s.toCharArray()) {
            	if (c == '0') {
            		ch++;
            	}
            }
            
            count = (long) Math.pow(2, ch);
            
            System.out.println(count);
        }

        in.close();
    }
}
