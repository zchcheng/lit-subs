class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        int[][] memo = new int[r][c];
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                memo[i][j] = -1;
            }
        }
        
        int res = 0;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                res = Math.max(res, helper(matrix, i, j, memo));
            }
        }
        
        return res;
    }
    
    int helper(int[][] m, int x, int y, int[][] memo) {
        if (memo[x][y] != -1) return memo[x][y];
        
        int res = 1;
        
        for(int[] dir : new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            
            if (nx < 0 || nx >= m.length || ny < 0 || ny >= m[0].length) continue;
            if (m[nx][ny] <= m[x][y]) continue;
            
            res = Math.max(res, 1 + helper(m, nx, ny, memo));
        }
        
        memo[x][y] = res;
        
        return res;
    }
}