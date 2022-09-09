class Solution {
    List<List<String>> res = new ArrayList<>();
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        helper(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), board);
        
        return res;
    }
    
    void helper(int row, Set<Integer> cols, Set<Integer> diag, Set<Integer> antiDiag, char[][] board) {
        if (row == board.length) {
            addBoardToResult(board);
            return;
        }
        
        for(int i = 0; i < board.length; i++) {
            if (cols.contains(i)) continue;
            if (diag.contains(row + i)) continue;
            if (antiDiag.contains(row - i)) continue;
            
            board[row][i] = 'Q';
            
            cols.add(i);
            diag.add(row + i);
            antiDiag.add(row - i);
            
            helper(row + 1, cols, diag, antiDiag, board);
            
            board[row][i] = '.';
            
            cols.remove(i);
            diag.remove(row + i);
            antiDiag.remove(row - i);
        }
    }
    
    void addBoardToResult(char[][] board) {
        List<String> result = new ArrayList<>();
        
        for(int i = 0; i < board.length; i++) {
            String row = "";
            
            for(int j = 0; j < board.length; j++) {
                row += board[i][j];
            }
            
            result.add(row);
        }
        
        res.add(result);
    }
}