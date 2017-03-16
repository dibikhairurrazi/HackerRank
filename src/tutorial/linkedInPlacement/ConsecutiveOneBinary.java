package tutorial.linkedInPlacement;

import java.util.Scanner;

public class ConsecutiveOneBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
    	
        int n = in.nextInt();
       
        String binary = Integer.toBinaryString(n);
        
        int max = 0;
        int current = 0;
        
        System.out.println(binary);
        
        for (char c : binary.toCharArray()) {
        	if (c == '1') {
        		current++;
        	} else {
        		
        		if (max < current) {
        			max = current;
        		}
        	
        		current = 0;
        	}
        }
        
        if (max < current) {
			max = current;
		}
        
        System.out.println(max);
        
        in.close();
	}

}
