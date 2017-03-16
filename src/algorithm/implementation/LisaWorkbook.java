package algorithm.implementation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/lisa-workbook
 */

public class LisaWorkbook {
	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        
        if (n == 1 && k == 1) {
        	System.out.println(c[0]);
        } else {
        	int page = 0;
            int count = 0;
            
            for (int i = 0; i < n; i++) {
            	for (int j = 1; j <= c[i]; j++) {
            		
            		if (j % k == 1) {
            			page++;
            		}
            		
            		if (j == page) {
            			count++;
            		}
            		
            	}
            }
            
            System.out.println(count);
        }

		in.close();
	}
}
