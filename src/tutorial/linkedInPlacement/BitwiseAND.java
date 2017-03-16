package tutorial.linkedInPlacement;

import java.util.Scanner;

public class BitwiseAND {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
    	
        int t = in.nextInt();
        int[] res = new int[t];
        int[][] temp = new int[1000][1000];
        
        for (int i = 0; i < t; i++) {
        	int n = in.nextInt();
        	int k = in.nextInt();
        	
        	int max = 0;
        	
        	for (int a = 1; a <= n; a++) {
        		for (int b = a + 1; b <= n; b++) {
        			
        			int c = 0;
        			
        			if (temp[a][b] != 0) {
        				c = temp[a][b];
        			} else {
        				c = a & b;
        				temp[a][b] = c;
        			}
        			
        			if ((c < k) && (c > max)) {
        				max = c;
        			}
        		}
        	}
        	
        	res[i] = max;
        }
        
        for (int r : res) {
        	System.out.println(r);
        }
        
        in.close();
	}

}
