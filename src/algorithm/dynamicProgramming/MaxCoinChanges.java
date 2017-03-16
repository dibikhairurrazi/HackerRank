package algorithm.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxCoinChanges {

	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        tmp = tmp.replace(" ","");
        String[] coinsArr = tmp.split(",");
        int[] coins = new int[coinsArr.length];
        for (int i = 0; i < coins.length;i++){
            coins[i] = Integer.parseInt(coinsArr[i]);
        }
        
        Arrays.sort(coins);
        int n = Integer.parseInt(br.readLine().replace(" ",""));
        System.out.println(maxCoins(n, coins));
    }
	
    private static int maxCoins(int n, int[]coins){
		int[] results = new int[n+1];
        results[0] = 1;
        for(int i=0; i<coins.length; i++) {
        	for(int j=coins[i]; j<=n; j++)
        	{
        		results[j] += results[j - coins[i]];
        	}
        }
  
        return results[n];
    }
	
}
