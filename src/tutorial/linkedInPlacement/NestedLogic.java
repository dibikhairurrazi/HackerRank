package tutorial.linkedInPlacement;

import java.util.Scanner;

public class NestedLogic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
    	
        int[] actual = new int[3];
        int[] expected = new int[3];
        
        for (int i = 0; i < 3; i++) {
        	actual[i] = in.nextInt();
        }
        
        for (int i = 0; i < 3; i++) {
        	expected[i] = in.nextInt();
        }
        
        if (expected[2] < actual[2]) {
        	System.out.println(10000);
        } else if (expected[2] == actual[2]) {
        	if (expected[1] < actual[1]) {
        		int x = actual[1] - expected[1];
        		System.out.println(x * 500);
        	} else if (expected[1] == actual[1]) {
        		if (expected[0] < actual[0]) {
        			int y = actual[0] - expected[0];
        			System.out.println(y * 15);
        		} else {
        			System.out.println(0);
        		}
        	} else {
        		System.out.println(0);
        	}
        } else {
        	System.out.println(0);
        }
        
        in.close();
	}

}
