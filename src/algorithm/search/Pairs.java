package algorithm.search;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Pairs {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
        	map.put(in.nextInt(), 0);
        }
        
        int count = 0;
        
        for (int i : map.keySet()) {
        	if (map.containsKey(i + k)) {
        		count++;
        	}
        	
        	if (map.containsKey(i - k)) {
        		count++;
        	}
        }
        
        System.out.println(count / 2);
        
        in.close();
    }
}
