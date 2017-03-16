package algorithm.string;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/camelcase
 */

public class CamelCase {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        
        String caps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        int i = 1;
        
        for (Character c : s.toCharArray()) {
        	
        	if (caps.contains(c.toString())) {
        		i++;
        	}
        }
        
        System.out.println(i);
        
        scanner.close();
    }
	
}
