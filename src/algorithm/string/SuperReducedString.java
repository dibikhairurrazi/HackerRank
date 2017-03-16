package algorithm.string;

import java.util.LinkedList;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/reduced-string
 */

public class SuperReducedString {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
        String s = in.next();
        
		LinkedList<Character> q = new LinkedList<Character>();
		for(int i = 0; i < s.length(); i++) {
			if(!q.isEmpty() && q.peekLast() == s.charAt(i)) {
				q.removeLast();
			}
			else {
				q.addLast(s.charAt(i));
			}
		}
		for(char out: q) {
			System.out.print(out);
		}
		if(q.size() == 0) {
			System.out.println("Empty String");
		}
    
        in.close();
    }
}
