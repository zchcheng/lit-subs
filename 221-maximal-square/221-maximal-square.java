class Solution {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int res = 0;
        int[][] dp = new int[r][c];
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (matrix[i][j] == '0') continue;
                
                int[][] toCheck = new int[][] { {0, -1}, {-1, 0}, {-1, -1}};
                int min = Integer.MAX_VALUE;
                
                for(int[] n : toCheck) {
                    int ni = i + n[0];
                    int nj = j + n[1];
                    
                    int v = (ni < 0 || nj < 0)? 0 : dp[ni][nj];
                    min = Math.min(min, v);
                }
                
                dp[i][j] = Math.max(1, min + 1);
                res = Math.max(res, dp[i][j] * dp[i][j]);
            }
        }
        
        return res;
    }
}