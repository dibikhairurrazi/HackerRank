package algorithm.bitManipulation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/and-product
 */

public class ANDProduct {

	public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
      
        int totalTestCase = scanner.nextInt();
        long[] res = new long[totalTestCase];
        
        for (int i = 0; i < totalTestCase; i++) {
        	
        	String[] test = new String[2];
        	
        	for (int j = 0; j < 2; j++) {
        		test[j] = scanner.next();
        	}
        	
        	long l = Long.parseLong(test[0]);
        	long r = Long.parseLong(test[1]);
        	
        	if (l > r) {
        		long a = l;
        		l = r;
        		r = a;
        	}
        	
        	long t = l;
        	
        	while (l < r) {
        		l++;
        		
        		t = t & l;
        	}
        	
        	res[i] = t;
        }
        
        for (int i = 0; i < totalTestCase; i++) {
        	System.out.println(res[i]);
        }
  
        scanner.close();
    }
}
