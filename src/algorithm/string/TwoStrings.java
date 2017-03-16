package algorithm.string;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/two-strings
 */

public class TwoStrings {

	public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
      
        int totalTestCase = scanner.nextInt();
        String[] res = new String[totalTestCase];
        
        for (int i = 0; i < totalTestCase; i++) {
        	
        	String[] test = new String[2];
        	
        	for (int j = 0; j < 2; j++) {
        		test[j] = scanner.next();
        	}
        	
        	String a = test[0];
        	String b = test[1];
        	
        	res[i] = hasCommonString(a, b) ? "YES" : "NO";
        	
        }
        
        for (int i = 0; i < totalTestCase; i++) {
        	System.out.println(res[i]);
        }
  
        scanner.close();
	}
    
    public static boolean hasCommonString(String s1, String s2) {
        return (toInt(s1) & toInt(s2)) > 0;
    }

    private static int toInt(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++)
            res |= 1 << (str.charAt(i) - 'a');
        return res;
    }
}
