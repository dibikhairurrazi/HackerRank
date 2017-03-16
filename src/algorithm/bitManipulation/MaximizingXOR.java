package algorithm.bitManipulation;

import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/maximizing-xor
 */

public class MaximizingXOR {

	static int maxXor(int l, int r) {

        int max = -1;
        
        for (int i = l; i <= r; i++) {
            for (int j = l; j <= r; j++) {
                int res = (i ^ j);
                if (res > max) {
                    max = res;
                }
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        in.close();
    }
}
