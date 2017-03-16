package algorithm.string;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/the-love-letter-mystery
 */

public class LoveLetterMystery {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for (int i = 0; i < t; i++) {
			String s = in.next();
			String left = "", right = "";
			
			if (s.length() % 2 == 0) {
				left = s.substring(0, s.length() / 2);
				right = new StringBuilder(s.substring(s.length() / 2)).reverse().toString();
			} else {
				left = s.substring(0, (s.length() - 1) / 2);
				right = new StringBuilder(s.substring(((s.length() - 1) / 2) + 1)).reverse().toString();
			}
			
			int count = 0;
			
			for (int j = 0; j < left.length(); j++) {
				if (left.charAt(j) != right.charAt(j)) {
					int x = Math.abs(left.charAt(j) - right.charAt(j));
					count = count + x;
				}
			}
			
			System.out.println(count);
		}
		in.close();
		
	}

}
