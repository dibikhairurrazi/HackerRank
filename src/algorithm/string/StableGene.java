package algorithm.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/bear-and-steady-gene
 */

public class StableGene {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        
        int limiter = n/4;
        
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('G', -1 * limiter);
        charMap.put('A', -1 * limiter);
        charMap.put('C', -1 * limiter);
        charMap.put('T', -1 * limiter);
        
        for(int i = 0; i < s.length(); i++){
            charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
        }
        
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        
        while(i < s.length() && j < s.length()){
            if(!isStable(charMap)){
                charMap.put(s.charAt(j), charMap.get(s.charAt(j)) - 1);
                j++;
            }
            else{
                min = Math.min(min, j - i);
                charMap.put(s.charAt(i), charMap.get(s.charAt(i)) + 1);
                i++;
            }
        }
        
        System.out.println(min);
        
        in.close();
    }

	public static boolean isStable(Map<Character, Integer> charMap){
        return charMap.get('G') <= 0 && 
        		charMap.get('A') <= 0 && 
        		charMap.get('C') <= 0 && 
        		charMap.get('T') <= 0;
    }
}
