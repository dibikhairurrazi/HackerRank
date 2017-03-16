package algorithm.implementation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited
 */

public class JumpingOnTheCloudRevisited {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        
        int e = 100;
        int pos = -1;
        int i = 0;
        
        while (e > 0 && pos != 0) {
        	i = i + k;
        	e = e - 1;
        		
        	if (i >= n) {
        		i = 0;
        	}
        	
        	if (c[i] == 1) {
        		e = e - 2;
        	}
        	
        	pos = i;
        }
        
        System.out.println(e);
        
		in.close();
    }
}
