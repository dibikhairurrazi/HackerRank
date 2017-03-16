package algorithm.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/abbr
 */

public class Abbreviation {

	public static void main(String[] args) {
		
		List<String> results = new ArrayList<>();
		
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++) {
            String a = in.next();
            String b = in.next();
            
            String result = isAbbreviatable(a, b) ? "YES" : "NO";
            results.add(result);
        }
       
        for (String r : results) {
        	System.out.println(r);
        }
        
	    in.close();
	}
	
	public static boolean isAbbreviatable(String a, String b){

        if (b.length() > a.length())
            return false;

        int aMark = 0;
        int bMark = 0;
        int lower = 0;

        while (aMark < a.length()){

            if (bMark >= b.length()) {
                if (Character.isUpperCase(a.charAt(aMark))) {
                	return false;
                } else {
                	aMark++;
                }
                
            } else {
            	
                char aChar = a.charAt(aMark);
                char bChar = b.charAt(bMark);

                if (aChar == bChar) {
                    aMark++;
                    bMark++;
                    lower = bMark;
                } else if (lower < b.length() && Character.isLowerCase(aChar) &&
                        Character.toUpperCase(aChar) == b.charAt(lower)) {
               
                    aMark++;
                    lower++;
                    
                } else if (Character.isUpperCase(aChar)) {
                    
                    if (bMark <= lower) {
                    	bMark++;
                    } else {
                    	return false;
                    }
                    
                } else {
                	aMark++;
                }
            }
        }

        return (bMark >= b.length() || lower >= b.length());

    }
}
