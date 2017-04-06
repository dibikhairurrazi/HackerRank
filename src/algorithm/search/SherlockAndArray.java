package algorithm.search;

import java.util.Scanner;

public class SherlockAndArray {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        
        for (int t_i = 0; t_i < t; t_i++) {
        	int n = in.nextInt();
        	int[] arr = new int[n];
        	
        	for (int i = 0; i < n; i++) {
        		arr[i] = in.nextInt();
        	}
        	
        	System.out.println(getBalanceIndex(arr) ? "YES" : "NO");
        }
        
        in.close();
	}
	
	private static boolean getBalanceIndex(int[] arr) {
		int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            
            int leftSum = 0;
            int rightSum = 0;
            for (int i = 0; i < mid; i++) {
            	leftSum += arr[i];
            }
            
            for (int i = mid + 1; i < arr.length; i++) {
            	rightSum += arr[i];
            }
            
            if (leftSum == rightSum) {
                return true;
            }
            if (leftSum > rightSum) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        
        return false;
	}
}
