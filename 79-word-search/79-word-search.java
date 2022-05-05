class Solution {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                if (helper(board, i, j, arr, 0)) return true;
        
        return false;
    }
    
    boolean helper(char[][] board, int r, int c, char[] arr, int i) {
        if (i == arr.length) return true;
        
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || arr[i] != board[r][c]) {
            return false;
        }
        
        board[r][c] = '!';
        
        for(int[] nx : new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}) {
            int nr = r + nx[0];
            int nc = c + nx[1];
            if (helper(board, nr, nc, arr, i + 1)) {
                return true;
            }
        }
        
        board[r][c] = arr[i];
        
        return false;
    }
}
