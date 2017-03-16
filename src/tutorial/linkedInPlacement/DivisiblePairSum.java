package tutorial.linkedInPlacement;

import java.util.Scanner;

public class DivisiblePairSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
	    	
        int n = in.nextInt();
        int k = in.nextInt();
        int[] A = new int[n];
        
        for(int i = 0 ; i < n ; i++) {
            A[i] = in.nextInt();
        }
        
        System.out.println(findDivisiblePair(A, k));
        
        in.close();
	}
	
	private static int findDivisiblePair(int[] A, int k) {
		
		int[][] temp = new int[A.length][A.length];
		
		if (A.length == 2) {
			return (((A[0] + A[1]) % k) == 0) ? 1 : 0;
		} else {
			
			int count = 0;
			
			for (int i = 0; i < A.length; i++) {
				for (int j = (i + 1); j < A.length; j++) {
					if (temp[i][j] == 1) {
						count++;
					} else {
						temp[i][j] = ((A[i] + A[j]) % k) == 0 ? 1 : 2;
						temp[j][i] = temp[i][j];
						
						if (temp[i][j] == 1) {
							count++;
						}
					}
				}
			}
			
			return count;
		}
	}

}
