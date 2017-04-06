package algorithm.search;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KnightLOnAChessboard {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
       
        Point endPoint = new Point(n - 1, n - 1);
        
        for (int i = 1; i < n; i++) {
        	for (int j = 1; j < n; j++) {
        		
        		Point startPoint = new Point(0, 0);
        		
        		List<Point> nextPos = new ArrayList<>();
        		List<Point> visited = new ArrayList<>();
        		
        		int totalMove = 0;
        		
        		nextPos = findNext(visited, startPoint, i, j, n);
        		
        		while (!nextPos.isEmpty()) {
        			
        			totalMove++;
        			
        			List<Point> allPossible = new ArrayList<>();
        			
        			boolean found = false;
        			
        			for (Point p : nextPos) {
        				
        				if (!visited.contains(p)) {
        					visited.add(p);
        					
        					if ((p.x == endPoint.x) && ((p.y == endPoint.y))) {
            					found = true;
            					break;
            				}
            				
            				List<Point> nextMove = findNext(visited, p, i, j, n);
            				allPossible.addAll(nextMove);
        				}
        			}
        			
        			if (found) {
        				break;
        			}
        			
        			nextPos = allPossible;
        		}
        		
        		if (!visited.contains(endPoint)) {
        			totalMove = -1;
        		}
        		
        		System.out.print(totalMove + " ");
        	}
        	
        	System.out.println();
        }
        
        in.close();
    }
	
	private static List<Point> findNext(List<Point> visited, Point p, int a, int b, int n) {
		
		List<Point> next = new ArrayList<>();
		int startx = p.x;
		int starty = p.y;
		
		List<Point> moves = getMoves(a, b);
		
		for (Point p2 : moves) {
			if (isMoveValid(p, p2.x, p2.y, n)) {
				
				Point p3 = new Point(startx + p2.x, starty + p2.y);
				
				if (!visited.contains(p3)) {
					next.add(p3);
				}
			}
		}
		
		return next;
	}
	
	private static boolean isMoveValid(Point p1, int a, int b, int n) {
		int x = p1.x;
		int y = p1.y;
		
		boolean valid = true;
		
		if (x + a < 0 || x + a >= n || y + b < 0 || y + b >= n) {
			valid = false;
		}
		
		return valid;
	}
	
	private static List<Point> getMoves(int a, int b) {
		List<Point> moves = new ArrayList<>();
		moves.add(new Point(a, b));
		moves.add(new Point(a, -b));
		moves.add(new Point(-a, b));
		moves.add(new Point(-a, -b));
		moves.add(new Point(b, a));
		moves.add(new Point(b, -a));
		moves.add(new Point(-b, a));
		moves.add(new Point(-b, -a));
		
		return moves;
	}
}
