class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        
        if (r == 0) return 0;
        
        int c = grid[0].length;
        int n = 0;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (grid[i][j] != '1') { continue; }
                helper(i, j, grid);
                n++;
            }
        }
        
        return n;
    }
    
    void helper(int r, int c, char[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] != '1') {
            return;
        }
        
        grid[r][c] = '0';
        
        for(int[] n : new int[][] { {1, 0}, {0, 1}, {-1, 0}, {0, -1} }) {
            helper(r + n[0], c + n[1], grid);
        }
    }
}