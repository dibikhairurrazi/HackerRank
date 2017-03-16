package algorithm.implementation;

import java.util.Scanner;

public class MiniMaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		
		long[] A = new long[5];
		
		long smallest = 10000000000L;
		long biggest = -1;
		long total = 0;
		
		for (int i = 0; i < 5; i++) {
			A[i] = in.nextLong();
			if (A[i] < smallest) {
				smallest = A[i];
			}
			
			if (A[i] > biggest) {
				biggest = A[i];
			}
			
			total = total + A[i];
		}
		
		System.out.print((total - biggest) + " " + (total - smallest));
		
		in.close();
	}

}
