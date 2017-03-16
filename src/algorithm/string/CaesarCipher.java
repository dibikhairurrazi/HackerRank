package algorithm.string;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/caesar-cipher-1
 */

public class CaesarCipher {

	private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private static String caps = alphabet.toUpperCase();
	
	public static void main(String[] args) {
        
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        
        String used = s.substring(0, n);
        
        if (k > 26) {
        	k = k % 26;
        }
        
        String res = cipher(used, k);
        
        System.out.println(res);
        
        in.close();
    }
	
	private static String cipher(String msg, int shift){
	    String s = "";
	    for(Character ch : msg.toCharArray()){
	    	
	    	char c = (char)(ch + shift);
	    	
	    	if (alphabet.contains(ch.toString())) {
	    		s += (c > 'z') ? (char)(ch - (26-shift)) : (char)(ch + shift);
	    	} else if (caps.contains(ch.toString())){
	    		s += (c > 'Z') ? (char)(ch - (26-shift)) : (char)(ch + shift);
	    	} else {
	    		s += ch.toString();
	    	}
	    }
	    return s;
	}
}
