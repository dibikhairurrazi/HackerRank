package algorithm.bitManipulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/lonely-integer
 */

public class LonelyInteger {

	static int lonelyinteger(int[] a) {
	       
	       int res = 0;
	       
	       Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	       
	       for (int x : a) {
	           int total = (map.get(x) != null) ? map.get(x) : 0; 
	           if (total == 0) {
	               map.put(x, 1);
	           } else {
	               map.remove(x);
	           }
	        }
	       
	        for (Entry<Integer, Integer> entry : map.entrySet()) {
	            res = entry.getKey();
	        }
	       
	        return res;
	    }
	   public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int res;
	        
	        int _a_size = Integer.parseInt(in.nextLine());
	        int[] _a = new int[_a_size];
	        int _a_item;
	        String next = in.nextLine();
	        String[] next_split = next.split(" ");
	        
	        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
	            _a_item = Integer.parseInt(next_split[_a_i]);
	            _a[_a_i] = _a_item;
	        }
	        
	        res = lonelyinteger(_a);
	        System.out.println(res);
	        
	        in.close();
	    }
	
}
