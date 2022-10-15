class Solution {
    int mask = 0;
    
    public boolean isValidSudoku(char[][] board) {
        boolean result = true;
        for(int i = 0; result && i < board.length; i++) result &= checkRow(board, i);
        for(int i = 0; result && i < board[0].length; i++) result &= checkCol(board, i);
        for(int i = 0; result && i < board.length; i += 3) {
            for(int j = 0; result && j < board[0].length; j += 3) {
                result &= checkBox(board, new int[] {i, j}, new int[] {i + 2, j + 2});
            }
        }
        
        return result;
    }
    
    boolean checkRow(char[][] board, int row) {
        reset();
        for(int c = 0; c < board[row].length; c++) {
            if (!add(board[row][c])) return false;
        }
        return true;
    }
    
    boolean checkCol(char[][] board, int col) {
        reset();
        for(int r = 0; r < board.length; r++) {
            if (!add(board[r][col])) return false;
        }
        return true;
    }
    
    boolean checkBox(char[][] board, int[] ul, int[] br) {
        reset();
        for(int r = ul[0]; r <= br[0]; r++) {
            for(int c = ul[1]; c <= br[1]; c++) {
                if (!add(board[r][c])) return false;
            }
        }
        return true;
    }
    
    void reset() {
        mask = 0;
    }
    
    boolean add(char n) {
        if (n == '.') return true;
        
        int b = 1 << (Character.getNumericValue(n) - 1);
        if ((mask & b) != 0) return false;
        mask |= b;
        
        return true;
    }
}