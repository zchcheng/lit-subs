class TicTacToe {
    int[][] board = new int[0][0];

    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (check(row, col, player)) return player;
        return 0;
    }
    
    boolean check(int row, int col, int player) {
        return checkRow(row, player) || checkCol(col, player) || checkDiag(player) || checkAntiDiag(player);
    }
    
    boolean checkRow(int row, int player) {
        boolean result = true;
        
        for(int i = 0; i < board.length; i++) {
            if (board[row][i] != player) {
                result = false;
                break;
            }
        }
        
        return result;
    }
    
    boolean checkCol(int col, int player) {
        boolean result = true;
        
        for(int i = 0; i < board.length; i++) {
            if (board[i][col] != player) {
                result = false;
                break;
            }
        }
        
        return result;
    }
    
    boolean checkDiag(int player) {
        boolean result = true;
        
        for(int i = 0; i < board.length; i++) {
            if (board[i][i] != player) {
                result = false;
                break;
            }
        }
        
        return result;
    }
    
    boolean checkAntiDiag(int player) {
        boolean result = true;
        
        for(int i = 0; i < board.length; i++) {
            if (board[i][board.length - i - 1] != player) {
                result = false;
                break;
            }
        }
        
        return result;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */