package algorithm.string;

import java.util.*;

/*
 * Link : https://www.hackerrank.com/challenges/sherlock-and-valid-string
 */

public class SherlockAndValidString {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String s = in.next();
		Map<Character, Integer> maps = new HashMap<Character, Integer>();
		
		for (char c : s.toCharArray()) {
			if (maps.containsKey(c)) {
				maps.put(c, maps.get(c) + 1);
			} else {
				maps.put(c, 1);
			}
		}
		
		Map<Integer, Integer> frequency = new HashMap<Integer, Integer>();
		
		for (int i : maps.values()) {
			if (frequency.containsKey(i)) {
				frequency.put(i, frequency.get(i) + 1);
			} else {
				frequency.put(i, 1);
			}
		}
		
		if (frequency.size() == 1) {
			System.out.println("YES");
		} else if (frequency.size() == 2) {
			if (frequency.values().contains(1)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} else {
			System.out.println("NO");
		}
		
		in.close();
	}
}
