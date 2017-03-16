package algorithm.graphTheory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/bfsshortreach
 */

public class BreadthFirstSearchShortReach {
	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> allResult = new ArrayList<List<Integer>>();
        
        int totalTestCase = scanner.nextInt();
        
        for (int i = 0; i < totalTestCase; i++) {
        	
        	int[] nodeDesc = new int[2];
        	
        	for (int j = 0; j < 2; j++) {
        		nodeDesc[j] = scanner.nextInt();
        	}
        	
        	int totalNode = nodeDesc[0];
        	int totalEdge = nodeDesc[1];
        	
        	Map<Integer, List<Integer>> moveList = new HashMap<Integer, List<Integer>>();
        	
        	List<String> edgeList = new ArrayList<String>();
        	
        	for (int j = 0; j < totalEdge; j++) {
        		
        		int[] edges = new int[2];
        		
        		for (int k = 0; k < 2; k++) {
        			edges[k] = scanner.nextInt();
        		}
        		
        		edgeList.add(edges[0] + "-" + edges[1]);
        		edgeList.add(edges[1] + "-" + edges[0]);
        		
        	}
        	
        	int startingNode = scanner.nextInt();
        	
        	for (String s : edgeList) {
        		String[] sa = s.split("-");
        		
        		int l = Integer.parseInt(sa[0]);
        		int r = Integer.parseInt(sa[1]);
        		
        		List<Integer> intList = moveList.get(l) != null ? moveList.get(l) : new ArrayList<Integer>();
        		intList.add(r);
        		moveList.put(l, intList);
        	}
        	
        	
        	List<Integer> result = new ArrayList<Integer>();
        	
        	Map<Integer, Integer> totalMoveNeeded = new HashMap<Integer, Integer>();
        			
        	List<Integer> visited = new ArrayList<Integer>();
        	List<Integer> nextAttempt = new ArrayList<Integer>();
        	visited.add(startingNode);
        	nextAttempt.add(startingNode);
        	
        	int moves = 0;
        	
        	while (visited.size() != totalNode) {
        		
        		List<Integer> nextAttemptList = new ArrayList<Integer>();
        		
        		moves++;
        		
        		for (Integer j : nextAttempt) {
        			List<Integer> possibleMoves = moveList.get(j);
        			if (possibleMoves == null || possibleMoves.isEmpty()) {
        				break;
        			}
        			
        			for (int possible : possibleMoves) {
        				if (!visited.contains(possible)) {
        					visited.add(possible);
        					nextAttemptList.add(possible);
        				}
        				
        				if (totalMoveNeeded.get(possible) == null) {
        					totalMoveNeeded.put(possible, moves);
        				}
        			}
        		}
        		
        		nextAttempt = nextAttemptList;
        		
        		if (nextAttempt.isEmpty()) {
        			break;
        		}
        	}
        	
        	for (int l = 1; l <= totalNode; l++) {
        		if (l != startingNode) {
        			
        			int intresult = 0;
        			
        			if (totalMoveNeeded.get(l) == null) {
        				intresult = -1;
        			} else {
        				intresult = totalMoveNeeded.get(l) * 6;
        			}
        			
        			result.add(intresult);
        		}
        	}
        	
        	allResult.add(result);
        }
        
        for (List<Integer> res : allResult) {
        	for (int re : res) {
        		System.out.print(re + " ");
        	}
        	
        	System.out.println();
        }
        
        scanner.close();
    }
	
}
