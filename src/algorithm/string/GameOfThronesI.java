package algorithm.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/game-of-thrones
 */

public class GameOfThronesI {

	public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String testCase = scanner.nextLine();
        
        Map<Character, Integer> map = new HashMap<>();
        
        boolean isEven = (testCase.length() % 2 == 0);        
        boolean palindrom = true;
        
        for (int i = 0; i < testCase.length(); i++) {
            int n = 0;
            
            if (map.get(testCase.charAt(i)) != null) {
                n = map.get(testCase.charAt(i));
                n++;
            } else {
                n = 1;
            }
            
            map.put(testCase.charAt(i), n);
        }
        
        if (isEven) {
        
            for (Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    palindrom = false;
                }
            }
            
        } else {
          
            int x = 0;
            
            for (Entry<Character, Integer> entry : map.entrySet()) {
              
                if (entry.getValue() % 2 != 0) {
                    x++;
                }
            }
            
            if (x > 1) {
                palindrom = false;
            }
            
        }
        
        System.out.println(palindrom ? "YES" : "NO");
        
        scanner.close();
    }
}
