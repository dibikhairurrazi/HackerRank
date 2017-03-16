package algorithm.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/cut-the-sticks
 */

public class CutTheSticks {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Integer> intList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            intList.add(in.nextInt());
        }
        
        while (intList.size() > 0) {
        	System.out.println(intList.size());
        	int s = smallest(intList);
        	
        	List<Integer> newList = new ArrayList<>();
        	
        	for (int i : intList) {
        		int x = i - s;
        		if (x > 0) {
        			newList.add(x);
        		}
        	}
        	
        	intList.clear();
        	intList.addAll(newList);
        }
        
        in.close();
    }
	
	private static int smallest(List<Integer> list) {
		int max = 99999999;
		for (Integer i : list) {
			if (i < max) {
				max = i;
			}
		}
		
		return max;
	}
}
