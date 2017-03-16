package algorithm.graphTheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/the-quickest-way-up
 */

public class SnakeAndLadderQuickestWayUp {
	
	public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);

        int totalTestCase = scanner.nextInt();
        int[] res = new int[totalTestCase];
        
        for (int i = 0; i < totalTestCase; i++) {
        	
        	Map<Integer, Integer> snakeAndLadders = new HashMap<Integer, Integer>();
            Map<Integer, List<Integer>> moves = new HashMap<Integer, List<Integer>>();
        	
        	int totalLadder = scanner.nextInt();
        	
        	for (int j = 0; j < totalLadder; j++) {
        		String[] ladders = new String[2];
        		
        		for (int k = 0; k < 2; k++) {
        			ladders[k] = scanner.next();
        		}
        		
        		snakeAndLadders.put(Integer.parseInt(ladders[0]), Integer.parseInt(ladders[1]));
        	}
        	
        	int totalSnake = scanner.nextInt();
        	
        	for (int j = 0; j < totalSnake; j++) {
        		int[] snakes = new int[2];
        		
        		for (int k = 0; k < 2; k++) {
        			snakes[k] = scanner.nextInt();
        		}
        		
        		snakeAndLadders.put(snakes[0],snakes[1]);
        	}
        	
        	for (int n = 1; n < 100; n++) {
        		
        		List<Integer> result = new ArrayList<Integer>();
        		
        		if (!snakeAndLadders.containsKey(n)) {
        			for (int j = 1; j <= 6; j++) {
            			int target = n + j;
            			
            			if (target <= 100) {
            				if (snakeAndLadders.get(target) != null) {
                				target = snakeAndLadders.get(target);
                			}
            				
            				result.add(target);
            			}

            		}
            		
            		moves.put(n, result);
        		}
        	}

        	int move = findMaxStep(moves);

        	res[i] = move;
        }
        
        for (int i = 0; i < totalTestCase; i++) {
        	System.out.println(res[i]);
        }
  
        scanner.close();
	}
    
    private static int findMaxStep(Map<Integer, List<Integer>> moves) {
    	
    	int move = 0;
    	int pos = 1;
    	
    	List<Integer> visited = new ArrayList<Integer>();
    	List<Integer> currentPosList = new ArrayList<Integer>();
    	currentPosList.add(pos);
    	
    	boolean solutionAvailable = false;
    	
    	for (Entry<Integer, List<Integer>> entry : moves.entrySet()) {
    		if (entry.getValue().contains(100)) {
    			solutionAvailable = true;
    		}
    	}
 
    	boolean finish = false;
    	
    	if (solutionAvailable) {
    		while (!finish) {
        		
        		move++;
        		
        		List<Integer> possible = new ArrayList<Integer>();
        		
        		for (int c : currentPosList) {
        			
        			if (moves.get(c).contains(100)) {
        				finish = true;
    					break;
        			}
        			
        			for (int next : moves.get(c)) {
        				
        				if (next == 100) {
        					finish = true;
        					break;
        				}
        				
        				if (!visited.contains(next)) {
        					possible.add(next);
        					visited.add(next);
        				}
        			}
        		}
        		
        		currentPosList = possible;
        		
        		if (possible.contains(100)) {
        			finish = true;
        			break;
        		}
        	}

        	return move;
    	} else {
    		return -1;
    	}
    }
	
}
