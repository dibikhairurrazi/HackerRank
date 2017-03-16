package algorithm.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/sock-merchant
 */

public class SockMerchant {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        
        Map<Integer, Integer> sockMap = new HashMap<>();
        
        for (int i : c) {
        	if (sockMap.get(i) != null) {
        		int count = sockMap.get(i);
        		sockMap.put(i, count + 1);
        	} else {
        		sockMap.put(i, 1);
        	}
        }
        
        int result = 0;
        
        for (Entry<Integer, Integer> entry : sockMap.entrySet()) {
        	
        	int x = entry.getValue();
        	
        	result = result + (Math.floorDiv(x, 2));
        }
        
        System.out.println(result);
        
        in.close();
    }
}
