/**
 *
 * @author Bilawal
 */
public class knightTour {
    
    private static final int FIRST_DIM = 8;
    private static final int SECOND_DIM = 8;
    
    public static void main(String[] args){
        int [][] board = new int[FIRST_DIM][SECOND_DIM];
        System.out.println(solver(board, 0, 0)); // starting position for knight is (0, 0)
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
               
                if (board[i][j] / 10 < 1) System.out.print(board[i][j] + "  | ");
                else System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }
    
    private static boolean solver(int [][] board, int i, int j) {
        return helper(board, i, j, 1);
    }
    
    private static boolean helper(int [][] board, int row, int col, int k) {
        
        board[row][col] = k;
        if (k == board.length * board[0].length) return true;
        
        if (row <= FIRST_DIM-3 && col >= 1 && board[row+2][col-1] == 0 && helper(board, row+2, col-1, k+1)) {
            return true;
       

        } if (row >= 2 && col >= 1 && board[row-2][col-1] == 0 && helper(board, row-2, col-1, k+1)) {
            return true;


        } if (row <= FIRST_DIM-2 && col >= 2 && board[row+1][col-2] == 0 && helper(board, row+1, col-2, k+1)) {
            return true;


        } if (row >= 1 && col >= 2 && board[row-1][col-2] == 0 && helper(board, row-1, col-2, k+1)){
            return true;


        } if (row >= 2 && col <= SECOND_DIM-2 && board[row-2][col+1] == 0 && helper(board, row-2, col+1, k+1)) {
            return true;


        } if (row >= 1 && col <= SECOND_DIM-3 && board[row-1][col+2] == 0 && helper(board, row-1, col+2, k+1)) {
            return true;

            
        } if (row <= FIRST_DIM-3 && col <= SECOND_DIM-2 && board[row+2][col+1] == 0 && helper(board, row+2, col+1, k+1)) {
            return true;
            
            
        } if (row <= FIRST_DIM-2 && col <= SECOND_DIM-3 && board[row+1][col+2] == 0 && helper(board, row+1, col+2, k+1)) {
            return true;
        }
        
        board[row][col] = 0;
        return false;
    } 
}
