package algorithm.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoCharacters {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        
        s = s.substring(0, len);
        
        List<Character> availableChars = new ArrayList<>();
        
        for (char c : s.toCharArray()) {
        	if (!availableChars.contains(c)) {
        		availableChars.add(c);
        	}
        }
        
        int longest = -1;
        
        for (int i = 0; i < availableChars.size() - 1; i++) {
        	for (int j = i + 1; j < availableChars.size(); j++) {
        		
        		String out = s.replaceAll("[^" + availableChars.get(i) + availableChars.get(j) + "]", "");
        		
        		if (validString(out)) {
        			if (out.length() > longest) {
        				longest = out.length();
        			}
        		}
        	}
        }
        
        System.out.println(longest != -1 ? longest : 0);
        
        in.close();
    }
	
	private static boolean validString(String s) {
		char ch1 = s.charAt(0);
		char ch2 = s.charAt(1);
		
		boolean valid = true;
		
		for (int i = 2; i < s.length(); i++) {
			if (i % 2 == 0) {
				if (s.charAt(i) != ch1) {
					valid = false;
					break;
				}
			} else {
				if (s.charAt(i) != ch2) {
					valid = false;
					break;
				}
			}
		}
		
		return valid;
	}
}
