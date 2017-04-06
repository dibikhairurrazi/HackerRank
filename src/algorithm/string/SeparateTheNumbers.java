package algorithm.string;

import java.util.Scanner;

public class SeparateTheNumbers {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            
            if (s.length() == 1) {
            	System.out.println("NO");
            } else {
        		isBeautiful(s);
            }
        }
        
        in.close();
    }
	
	private static void isBeautiful(String s) {
		int i = 1;
		while (i <= (s.length() / 2)) {
			String sub = s.substring(0, i);
			
			if (sub.startsWith("0")) {
				break;
			}
			
			long num = Long.parseLong(sub);
			if (checkNext(s, i, sub, num)) {
				System.out.println("YES " + num);
				return;
			}
			
			i++;
		}
		
		System.out.println("NO");
	}
	
	private static boolean checkNext(String s, int startPos, String next, long expected) {
		long num = Long.parseLong(next);
		if (num != expected) {
			return false;
		}
		
		if (startPos == s.length()) {
			return true;
		}
		
		int nextStartPos = startPos + (int) Math.log10(num + 1) + 1;
		if (nextStartPos > s.length()) {
			return false;
		}
		
		String sub = s.substring(startPos, nextStartPos);
		return checkNext(s, nextStartPos, sub, expected + 1);
	}
}
