package tutorial.linkedInPlacement;

import java.util.Scanner;

public class LexicographicallyGreater {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
        	arr[i] = in.next();
        }
        
        for (String s : arr) {
        	
        	if (s.length() == 1) {
        		System.out.println("no answer");
        	} else {
        		char[] sArr = s.toCharArray();
            	
            	if (nextPermutation(sArr)) {
            		
            		String result = "";
            		
            		for (char c : sArr) {
            			result = result + c;
            		}
            		
            		System.out.println(result);
            	} else {
            		System.out.println("no answer");
            	}
        	}
        }
        
        in.close();
	}
	
	public static boolean nextPermutation(char[] s) {
	    int i = s.length - 1;
	    while (i > 0 && s[i - 1] >= s[i]) {
	        i--;
	    }

	    if (i <= 0) {
	        return false;
	    }

	    int j = s.length - 1;

	    while (s[j] <= s[i - 1]) {
	        j--;
	    }

	    char temp = s[i - 1];
	    s[i - 1] = s[j];
	    s[j] = temp;

	    j = s.length - 1;

	    while (i < j) {
	        temp = s[i];
	        s[i] = s[j];
	        s[j] = temp;
	        i++;
	        j--;
	    }

	    return true;
	}
}
