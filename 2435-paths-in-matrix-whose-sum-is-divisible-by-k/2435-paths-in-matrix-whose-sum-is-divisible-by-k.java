class Solution {
    final int modK = 1000000007;
    
    public int numberOfPaths(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;
        
        long[][][] dp = new long[r][c][k];
        
        for(int i = r - 1; i >= 0; i--) {
            for(int j = c - 1; j >= 0; j--) {
                int n = grid[i][j];
                
                if (i == r - 1 && j == c - 1) {
                    dp[i][j][n % k]++;
                    continue;
                }
                    
                for(int l = 0; l < k; l++) {
                    long down = (i == r - 1)? 0 : dp[i + 1][j][l];
                    long right = (j == c - 1)? 0 : dp[i][j + 1][l];
                    dp[i][j][(l + n) % k] = (down + right) % modK;
                }
            }
        }
        
        return (int)(dp[0][0][0] % modK);
    }
}