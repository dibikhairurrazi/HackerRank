package algorithm.implementation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/kangaroo
 */

public class Kangaroo {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        
        boolean stop = false;
        boolean flag = false;
        
        int pos1 = x1;
        int pos2 = x2;
        
        int latestDis = Math.abs(x2 - x1);
        
        while (!stop) {
        	pos1 = pos1 + v1;
        	pos2 = pos2 + v2;
        	
        	int dis = Math.abs(pos1 - pos2);
        	
        	if (pos1 == pos2) {
        		stop = true;
        		flag = true;
        	}
        	
        	if (latestDis <= dis) {
        		stop = true;
        	}
        }
        
        
        if (flag) {
        	System.out.println("YES");
        } else {
        	System.out.println("NO");
        }
        
        in.close();
    }
	
}
