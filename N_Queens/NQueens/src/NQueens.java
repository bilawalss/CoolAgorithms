/**
* Title: Solution to the N-Queens problem
* Author: Bilawal Samad Shaikh
*/

public class NQueens {
    
    private static int count = 0;
    private static int N;
    
    public static void main(String[] args) {
        int n = 8;  // solution to the 8 Queens problem
        int numberOfConfig = totalNQueens(n);
        System.out.println("With "+n+" as the dimension of each side of the board, the number of configurations are "+ numberOfConfig);
        
    }
    
    public static int totalNQueens(int n) {
        N = n;
        int [][] board = new int[n][n];
        for (int k = 0; k < N; k++) {
            helper(board, 0, k);   
        }
        
        return count;
    }
    
    private static void helper(int [][] board, int row, int col) {
        
        board[row][col] = 1;
       
            
        if (row == N-1) {
            count++;
            
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j]+" | ");
                }
                System.out.println();
            }
            System.out.println();
            
            board[row][col] = 0;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(isSafe(board, row+1, i)) helper(board, row+1, i);
        }
                    
        board[row][col] = 0;
        return;
    }
    
    
    private static boolean isSafe(int[][] board, int row, int col) {
        
        for(int i = 0; i < N; i++) {
            if (i == col) continue;
            if (board[row][i] == 1) return false;
        }
        
        for(int i = 0; i < N; i++) {
            if (i == row) continue;
            if (board[i][col] == 1) return false;
        }
        
        for(int i = 1, j = 1; i < N; i++, j++) {
            if (row+i < N && col+j < N && board[row+i][col+j] == 1) return false;
            if (row+i < N && col-j > -1 && board[row+i][col-j] == 1) return false;
            if (row-i > -1 && col+j < N && board[row-i][col+j] == 1) return false;
            if (row-i > -1 && col-j > -1 && board[row-i][col-j] == 1) return false;
        }
        
        
        return true;
    }
}
