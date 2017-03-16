package algorithm.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/happy-ladybugs
 */

public class HappyLadybugs {
	public static void main(String[] args) {

		List<String> results = new ArrayList<>();
		
		Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++){
        	
            @SuppressWarnings("unused")
			int n = in.nextInt();
            String b = in.next();
            
            String result = "";
            
            if (b.length() == 1) {
            	if (b.equals("_")) {
            		result = "YES";
            	} else {
            		result = "NO";
            	}
            } else {
            	Map<Character, Integer> charMap = new HashMap<>();

                for (char c : b.toCharArray()) {
                	if (charMap.get(c) != null) {
                		int count = charMap.get(c);
                		charMap.put(c, count + 1);
                	} else {
                		charMap.put(c, 1);
                	}
                }
                
                boolean single = false;
                
            	for (Entry<Character, Integer> entry : charMap.entrySet()) {
            		
            		if ((entry.getValue() == 1) && (entry.getKey() != '_')) {
            			single = true;
            		}
            	}
            	
            	if (single) {
            		result = "NO";
            	} else {
            		result = "YES";
            	}
                
                boolean diff = false;
            	
            	for (int i = 0; i < (b.length() - 2); i++) {
            		if (b.charAt(i) != b.charAt(i + 1)) {
            			if (b.charAt(i+1) != b.charAt(i + 2)) {
                            diff = true;
                        }
            		}
            	}
                
                if (diff) {
            		if (!b.contains("_")) {
            			result = "NO";
            		}
            	}
            }
            
            results.add(result);    
        }
        
        for (String r : results) {
        	System.out.println(r);
        }
        
        in.close();
	}
}
