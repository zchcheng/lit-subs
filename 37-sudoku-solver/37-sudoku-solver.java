class Solution {
    public void solveSudoku(char[][] board) {
        List<int[]> empty = new ArrayList<>();
        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if (board[i][j] == '.') empty.add(new int[] {i, j});
            }
        }
        
        helper(empty, 0, board);
    }
    
    boolean helper(List<int[]> empty, int i, char[][] board) {
        if (i >= empty.size()) return true;
        
        int[] p = empty.get(i);
        
        List<Integer> ps = possibleSolution(board, p[0], p[1]);
        
        if (ps.isEmpty()) return false;
        
        for(int n : ps) {
            board[p[0]][p[1]] = (char) (n + '0');
            if (helper(empty, i + 1, board)) return true;
        }
        
        board[p[0]][p[1]] = '.';
        
        return false;
    }
    
    List<Integer> possibleSolution(char[][] board, int x, int y) {
        boolean[] exist = new boolean[10];
        
        for(int i = 0; i < 9; i++) {
            if (board[x][i] != '.') exist[Character.getNumericValue(board[x][i])] = true;
            if (board[i][y] != '.') exist[Character.getNumericValue(board[i][y])] = true;
        }
        
        for(int i = 0; i < 3; i++) {
            int bx = (x / 3) * 3 + i;
            
            for(int j = 0; j < 3; j++) {
                int by = (y / 3) * 3 + j;
                if (bx == by) continue;
                if (board[bx][by] != '.') exist[Character.getNumericValue(board[bx][by])] = true;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        for(int i = 1; i <= 9; i++) {
            if (exist[i]) continue;
            res.add(i);
        }
        
        return res;
    }
}