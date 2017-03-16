package algorithm.string;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/beautiful-binary-string
 */

public class BeautifulBinaryString {

	public static void main(String[] args) {
        
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		String s = in.next();
		int count = 0;
		
		if (s.length() > n) {
			s = s.substring(0, n);
		}
		
		System.out.println(change(s, count));
		in.close();
    }
	
	private static int change(String s, int count) {
		if (!s.contains("010")) {
			return count;
		} else {
			return change(s.replaceFirst("010", "011"), count + 1);
		}
	}
}
