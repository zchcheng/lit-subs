class Solution {
    final int[][] moves = new int[][] {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (backtrack(board, word, 0, new int[] {i, j})) return true;
            }
        }
                    
        return false;
    }
    
    boolean backtrack(char[][] board, String word, int i, int[] loc) {
        char c = word.charAt(i);
        
        if (board[loc[0]][loc[1]] != c) return false;
        
        if (i == word.length() - 1) return true;
        
        board[loc[0]][loc[1]] = '#';
        
        boolean result = false;
        
        for(int[] move : moves) {
            int nx = loc[0] + move[0];
            int ny = loc[1] + move[1];
            
            if (nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
            
            result |= backtrack(board, word, i + 1, new int[] {nx, ny});
            
            if (result) break;
        }
        
        board[loc[0]][loc[1]] = c;
        
        return result;
    }
}