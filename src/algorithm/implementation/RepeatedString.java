package algorithm.implementation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/repeated-string
 */

public class RepeatedString {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        
        if (s.length() == 1) {
        	if (s.equals("a")) {
        		System.out.println(n);
        	} else {
        		System.out.println(0);
        	}
        } else {
        	
            long count =0;
            for(char c : s.toCharArray())
                if(c == 'a')
                count++;

             long factor = (n/s.length());
             long rem = (n%s.length());
             count =  factor*count  ;
             for(int i=0;i<rem;i++)
            	 if(s.charAt(i)=='a')
            		 count++;        
            System.out.println(count);
        }
        
        in.close();
    }
}
