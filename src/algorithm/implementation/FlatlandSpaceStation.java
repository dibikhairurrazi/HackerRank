package algorithm.implementation;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/flatland-space-stations
 */

public class FlatlandSpaceStation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m];
        for(int i = 0; i < m; i++) {
            c[i] = in.nextInt();
        }
        
        Arrays.sort(c);
        int mdx = Math.max(c[0], n - c[c.length - 1] - 1);
        for(int i = 0; i < m - 1; i++) {
            mdx = Math.max((c[i + 1] - c[i]) / 2, mdx);
        }
        
        System.out.println(mdx);
	    
	    in.close();
	}
}
