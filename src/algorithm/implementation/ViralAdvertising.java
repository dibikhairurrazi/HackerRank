package algorithm.implementation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/strange-advertising
 */

public class ViralAdvertising {

	public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int advertised = 5;
        int total = 0;
        
        for (int i = 0; i < x; i++) {
        	int current = (int) Math.floor(advertised / 2);
        	advertised = current * 3;
        	total = total + current;
        }
        
        System.out.println(total);
        
        in.close();
    }
	
}
