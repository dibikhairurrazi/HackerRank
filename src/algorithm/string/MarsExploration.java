package algorithm.string;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/mars-exploration
 */

public class MarsExploration {
	
	public static void main(String[] args) {
        
		Scanner in = new Scanner(System.in);
        String s = in.next();
        
        String temp = s.toUpperCase();
        int count = 0;
        while (temp.length() >= 3) {
        	
        	if (!(temp.substring(0, 3).equals("SOS"))) {
        		count = count + charDiffToSOS(temp.substring(0, 3));
        	}
        	
        	temp = temp.substring(3);
        }
        
        System.out.println(count);
  
        in.close();
    }
	
	private static int charDiffToSOS(String s) {
		
		int count = 0;
		
		count = count + (s.charAt(0) == 'S' ? 0 : 1);
		count = count + (s.charAt(1) == 'O' ? 0 : 1);
		count = count + (s.charAt(2) == 'S' ? 0 : 1);
		
		return count;
	}
}
