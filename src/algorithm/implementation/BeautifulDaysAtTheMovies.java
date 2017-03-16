package algorithm.implementation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/beautiful-days-at-the-movies
 */

public class BeautifulDaysAtTheMovies {

	public static void main(String[] args) {
		
	    Scanner scanner = new Scanner(System.in);
	    int start = scanner.nextInt();
	    int end = scanner.nextInt();
	    int k = scanner.nextInt();

	    int count = 0;
	    for (int i=start; i<= end; i++) {        
	        if ( (i - reverse(i)) % k == 0) {
	           count++; 
	        }        
	    }
	    
	    System.out.println(String.format("%d", count));
	    
	    scanner.close();
	}
	
	private static int reverse(int input) {
	 int reversedNum = 0;
	    while (input != 0) {    
	     int last_digit = input % 10;
	     reversedNum = reversedNum * 10 + last_digit;
	     input = input / 10; 
	}
	     return reversedNum;
	}
	
}
