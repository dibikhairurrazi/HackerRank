package algorithm.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/common-child
 */

public class CommonChild {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		
		List<Character> result = lcs(a.toCharArray(), b.toCharArray());
		
		System.out.println(result.size());
		
        in.close();
    }
	
	public static List<Character> lcs(char[] a, char[] b) {
		
	    int[][] lengths = new int[a.length + 1][b.length + 1];
	 
	    for (int i = 0; i < a.length; i++)
	        for (int j = 0; j < b.length; j++)
	            if (a[i] == b[j])
	                lengths[i + 1][j + 1] = lengths[i][j] + 1;
	            else
	                lengths[i + 1][j + 1] =
	                    Math.max(lengths[i + 1][j], lengths[i][j + 1]);
	 
	    List<Character> res = new ArrayList<>();
	    for (int x = a.length, y = b.length; x != 0 && y != 0; ) {
	    	
	        if (lengths[x][y] == lengths[x - 1][y])
	            x--;
	        else if (lengths[x][y] == lengths[x][y - 1])
	            y--;
	        else {
	            assert a[x - 1] == b[y - 1];
	            res.add(a[x - 1]);
	            x--;
	            y--;
	        }
	    }
	 
	    return res;
	}
}
