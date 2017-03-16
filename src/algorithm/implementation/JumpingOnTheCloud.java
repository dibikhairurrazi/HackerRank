package algorithm.implementation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/jumping-on-the-clouds
 */

public class JumpingOnTheCloud {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        
        int i = 0;
        int jump = 0;
        
        while (i < c.length - 1) {
        	
        	if (i + 2 < c.length) {
        		if (c[i + 2] != 1) {
            		i = i + 2;
            	} else {
            		i = i + 1;
            	}
        	} else {
        		i = i + 1;
        	}

        	jump++;
        }
        
        System.out.println(jump);
        
        in.close();
    }
}
