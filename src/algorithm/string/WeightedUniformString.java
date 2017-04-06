package algorithm.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeightedUniformString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
        
        String s = in.next();
        int n = in.nextInt();
        
        int totalVal = 0;
        
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(((int) s.charAt(0)) - 96, 0);
        
        for (int i = 1; i < s.length(); i++) {
        	char c = s.charAt(i);
        	
        	int val = ((int) c) - 96;
        	
        	if (c != s.charAt(i - 1)) {
        		countMap.put(val, 0);
        		totalVal = val;
        	} else {
        		totalVal = totalVal + val;
        		countMap.put(totalVal, 0);
        	}
        }
        
        for (int i = 0; i < n; i++) {
        	int k = in.nextInt();
        	System.out.println(countMap.containsKey(k) ? "yes" : "no");
        }

        in.close();
	}

}
