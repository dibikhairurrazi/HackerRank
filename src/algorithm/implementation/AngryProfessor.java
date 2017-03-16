package algorithm.implementation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/angry-professor
 */

public class AngryProfessor {

	public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();
        String[] results = new String[testCase];
        
        for (int i = 0; i < testCase; i++) {
            
            int[] totalAndThres = new int[2];
            
            
            for (int j = 0; j < 2; j++) {
                totalAndThres[j] = scanner.nextInt();
            }

            int x = totalAndThres[0];
            int[] something = new int[x];
            
            for (int j = 0; j < totalAndThres[0]; j++) {
                something[j] = scanner.nextInt();
            }
            
            int totalLate = 0;
            
            for (int j = 0; j < something.length; j++) {
                if (something[j] > 0) {
                    totalLate++;
                }
            }
            
            int notLate = totalAndThres[0] - totalLate;
            results[i] = (notLate >= totalAndThres[1] ) ? "NO" : "YES";
        }
        
        for (String result : results) {
            System.out.println(result);
        }
        
        scanner.close();
    }
}
