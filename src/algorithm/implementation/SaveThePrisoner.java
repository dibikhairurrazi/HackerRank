package algorithm.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/save-the-prisoner
 */

public class SaveThePrisoner {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
       List<Long> results = new ArrayList<Long>();
		
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
        	long n = in.nextInt();
        	long m = in.nextInt();
        	long s = in.nextInt();
        	
        	if (n == 1) {
        		results.add((long) 1);
        	} else if (m == 1) {
        		results.add(s);
        	} else {
        		long x = (m - 1) % n;
            	long fin = s + x;
            	
            	long res = fin % n;
            	
            	if (res == 0) {
            		results.add(n);
            	} else {
            		results.add(res);
            	}
            	
            	
        	}
        }
		
        for (long result : results) {
        	System.out.println(result);
        }
        
		in.close();
    }
}
