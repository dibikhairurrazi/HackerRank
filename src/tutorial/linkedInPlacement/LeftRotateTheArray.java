package tutorial.linkedInPlacement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LeftRotateTheArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
	    	
        int n = in.nextInt();
        int k = in.nextInt();
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++) {
            list.add(in.nextInt());
        }
        
        Collections.rotate(list, -k);
        
        for (int i : list) {
        	System.out.print(i + " ");
        }
        
        in.close();
	}
}
