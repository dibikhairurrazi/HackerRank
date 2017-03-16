package algorithm.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/pangrams
 */

public class Pangrams {

	public static void main(String[] args) {
     
        Scanner scanner = new Scanner(System.in);

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        String testCase = scanner.nextLine();
        String lowerCase = testCase.toLowerCase();
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < lowerCase.length(); i++) {
            if (map.get(lowerCase.charAt(i)) == null) {
                map.put(lowerCase.charAt(i), 1);
            }
        }
        
        boolean pangram = true;
        
        for (int i = 0; i < alphabet.length(); i++) {
            if (!map.containsKey(alphabet.charAt(i))) {
                pangram = false;
                break;
            }
        }
        
        System.out.println(pangram ? "pangram" : "not pangram");
        
        scanner.close();
    }
}
