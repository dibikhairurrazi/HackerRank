package algorithm.string;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/alternating-characters
 */

public class AlternatingCharacter {
	
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		
		for (int i = 0; i < t; i++) {
			
			String s = in.next();
			
			char prevChar = s.charAt(0);
			int removed = 0;
			
			for (int j = 1; j < s.length(); j++) {
				if (prevChar == s.charAt(j)) {
					removed++;
				} else {
					prevChar = s.charAt(j);
				}
			}
			
			System.out.println(removed);
			
		}
		
		in.close();
		
	}

}
