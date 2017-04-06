package algorithm.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MissingNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, Integer> mapN = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
        	int x = in.nextInt();
        	
        	if (mapN.containsKey(x)) {
        		mapN.put(x, mapN.get(x) + 1);
        	} else {
        		mapN.put(x, 1);
        	}
        }
        
        int m = in.nextInt();
        Map<Integer, Integer> mapM = new HashMap<>();
        
        for (int i = 0; i < m; i++) {
        	int x = in.nextInt();
        	
        	if (mapM.containsKey(x)) {
        		mapM.put(x, mapM.get(x) + 1);
        	} else {
        		mapM.put(x, 1);
        	}
        }
        
        List<Integer> missing = new ArrayList<>();
        
        for (int i : mapM.keySet()) {
        	if (mapN.get(i) == null || (mapN.get(i) < mapM.get(i))) {
        		
        		if (!missing.contains(i)) {
        			missing.add(i);
        		}	
        	}
        }
        
        Collections.sort(missing);
        
        for (int i : missing) {
        	System.out.print(i + " ");
        }
        
        in.close();
    }
}
