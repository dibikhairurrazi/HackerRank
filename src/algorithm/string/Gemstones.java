package algorithm.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/gem-stones
 */

public class Gemstones {

	public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int totalTestCase = scanner.nextInt();
        
        String[] testCase = new String[totalTestCase];
        
        int shortest = 1000;
        String s = "";
        
        for (int i = 0; i < totalTestCase; i++) {
            testCase[i] = scanner.next().toLowerCase();
            
            if (testCase[i].length() < shortest) {
                shortest = testCase[i].length();
                s = testCase[i];
            }
        }
   
        List<Character> charList = new ArrayList<>();
        
        for (int i = 0; i < shortest; i++) {
            if (!charList.contains(s.charAt(i))) {
                charList.add(s.charAt(i));
            }
        }
        
        int totalGem = 0;
        
        for (Character c : charList) {

            boolean gem = true;
            
            for (String test : testCase) {
                if (!test.contains(Character.toString(c))) {
                    gem = false;
                }
            }
            
            if (gem) {
                totalGem++;
            }
        }
        
        System.out.println(totalGem);
        
        scanner.close();
    }
}
