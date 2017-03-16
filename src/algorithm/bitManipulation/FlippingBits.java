package algorithm.bitManipulation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/flipping-bits
 */

public class FlippingBits {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
      
        int totalTestCase = scanner.nextInt();
        
        if (totalTestCase >= 1 && totalTestCase <= 100) {
        	long[] inputs = new long[totalTestCase];
            long maxInt= (long) Math.pow(2, 32) - 1;
            
            for (int i = 0; i < totalTestCase; i++) {
            	inputs[i] = scanner.nextLong();
            }
            
            for (int i = 0; i < totalTestCase; i++) {
            	System.out.println(maxInt - inputs[i]);
            }
        }
  
        scanner.close();
    }
}
