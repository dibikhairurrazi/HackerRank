package tutorial.linkedInPlacement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
    	
        int m = in.nextInt();
        int n = in.nextInt();
        int[] A = new int[m];
        int[] B = new int[n];
        
        for(int i = 0 ; i < m ; i++) {
            A[i] = in.nextInt();
        }
        
        for(int i = 0 ; i < n ; i++) {
            B[i] = in.nextInt();
        }
        
        List<Integer> results = lcs(A, B);
        
        for (int i = (results.size() - 1); i >= 0; i--) {
        	System.out.print(results.get(i) + " ");
        }
        
        in.close();
		
	}
	
	public static List<Integer> lcs(int[] a, int[] b) {
		
	    int[][] lengths = new int[a.length + 1][b.length + 1];
	 
	    // row 0 and column 0 are initialized to 0 already
	 
	    for (int i = 0; i < a.length; i++)
	        for (int j = 0; j < b.length; j++)
	            if (a[i] == b[j])
	                lengths[i+1][j+1] = lengths[i][j] + 1;
	            else
	                lengths[i+1][j+1] =
	                    Math.max(lengths[i+1][j], lengths[i][j+1]);
	 
	    // read the substring out from the matrix
	    List<Integer> res = new ArrayList<>();
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
