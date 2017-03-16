package algorithm.recursion;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Link : https://www.hackerrank.com/challenges/simplified-chess-engine
 */

public class SimplifiedChessEngine {

	static int[][] knight = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
	
	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int t_i = 0; t_i < t; t_i++) {
            int w = sc.nextInt();
            int b = sc.nextInt();
            int m = sc.nextInt();
            
            Piece[][] board = new Piece[4][4];
            for (int i = 0; i < w; i++) {
                char type = sc.next().charAt(0);
                char column = sc.next().charAt(0);
                int row = sc.nextInt() - 1;
                
                Piece p = new Piece(type, true);
                board[row][column - 'A'] = p;
            }
            for (int i = 0; i < b; i++) {
                char type = sc.next().charAt(0);
                char column = sc.next().charAt(0);
                int row = sc.nextInt() -1 ;
                
                Piece p = new Piece(type, false);
                board[row][column - 'A'] = p;
            }
            
            boolean win = exist(board, m);
            System.out.println(win ? "YES" : "NO");
        }
        
        sc.close();
    }
	
	static class Piece {
		char type;
		boolean isWhite;
		
		Piece(char type, boolean isWhite) {
            this.type = type;
            this.isWhite = isWhite;
        }
	}
	
	static Piece[][] copy(Piece[][] c) {
		Piece[][] t = new Piece[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                t[i][j] = c[i][j];
            }
        }
        return t;
	}
	
    static boolean inBoard(int row, int column) {
        return row >= 0 && column >= 0 && row < 4 && column < 4;
    }
    
    static void numPossible(Piece[][] board, int row, int column, int dRow, int dColumn, ArrayList<int[]> moves) {
        int d = 1;
        while (inBoard(row + d * dRow, column + d * dColumn)) {
            int newR = row + d * dRow;
            int newC = column + d * dColumn;
            if (board[newR][newC] != null && board[row][column].isWhite == board[newR][newC].isWhite) {
                return;
            }
            if (board[newR][newC] != null && board[row][column].isWhite != board[newR][newC].isWhite) {
                moves.add(new int[]{d * dRow, d * dColumn});
                return;
            }
            moves.add(new int[]{d * dRow, d * dColumn});
            d++;
        }
    }
    
    static void rookMoves(Piece[][] board, int row, int column, ArrayList<int[]> moves) {
        numPossible(board, row, column, 1, 0, moves);
        numPossible(board, row, column, -1, 0, moves);
        numPossible(board, row, column, 0, 1, moves);
        numPossible(board, row, column, 0, -1, moves);
    }
    
    static void bishopMoves(Piece[][] board, int row, int column, ArrayList<int[]> moves) {
        numPossible(board, row, column, 1, 1, moves);
        numPossible(board, row, column, 1, -1, moves);
        numPossible(board, row, column, -1, 1, moves);
        numPossible(board, row, column, -1, -1, moves);
    }
    
    static int[][] possibleMoves(Piece[][] board, int row, int column) {
        Piece p = board[row][column];
        ArrayList<int[]> moves = new ArrayList<>();
        
        if (p.type == 'Q') {
            rookMoves(board, row, column, moves);
            bishopMoves(board, row, column, moves);
        } else if (p.type == 'R') {
            rookMoves(board, row, column, moves);
        } else if (p.type == 'B') {
            bishopMoves(board, row, column, moves);
        } else if (p.type == 'N') {
            for (int i = 0; i < knight.length; i++) {
                int newRow = row + knight[i][0];
                int newColumn = column + knight[i][1];
                if (inBoard(newRow, newColumn)) {
                    moves.add(new int[]{knight[i][0], knight[i][1]});
                }
            }
        }
        
        int[][] t = new int[moves.size()][2];
        for (int i = 0; i < t.length; i++) {
            t[i] = moves.get(i);
        }
        return t;
    }
    
    static void doMove(Piece[][] board, int row, int column, int[] move) {
        Piece p = board[row][column];
        board[row][column] = null;
        board[row+move[0]][column+move[1]] = p;
    }
    
    static boolean win(Piece[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != null && !board[i][j].isWhite && board[i][j].type == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean lose(Piece[][] board) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != null && board[i][j].isWhite && board[i][j].type == 'Q') {
                    return false;
                }
            }
        }
        return true;
    }
    
    static boolean exist(Piece[][] board, int m) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != null && board[i][j].isWhite) {
                    int[][] moves = possibleMoves(board, i, j);
                    for (int[] move : moves) {
                        Piece[][] copy = copy(board);
                        doMove(copy, i, j, move);
                        if (win(copy)) {
                            return true;
                        }
                        if (m > 1) {
                            if (foreach(copy, m - 1)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    static boolean foreach(Piece[][] board, int m) {
        if (m == 1) {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != null && !board[i][j].isWhite) {
                    int[][] moves = possibleMoves(board, i, j);
                    for (int[] move : moves) {
                        Piece[][] copy = copy(board);
                        doMove(copy, i, j, move);
                        if (lose(copy)) {
                            return false;
                        }
                        if (m > 1) {
                            if (!exist(copy, m - 1)) {
                                return false;
                            }
                        }
                        
                    }
                }
            }
        }
        return true;
    }
}
