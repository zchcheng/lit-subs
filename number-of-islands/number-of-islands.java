class Solution {
    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        int result = 0;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (grid[i][j] != '1') continue;
                bfs(grid, i, j);
                result++;
            }
        }
        
        return result;
    }
    
    void bfs(char[][] grid, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[] {x, y});
        grid[x][y] = '0';
        
        while(!queue.isEmpty()) {
            int[] p = queue.poll();
            
            for(int[] next : new int[][] {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1}
            }) {
                int nx = p[0] + next[0];
                int ny = p[1] + next[1];
                
                if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || grid[nx][ny] != '1') {
                    continue;
                }
                
                grid[nx][ny] = '0';
                queue.offer(new int[] {nx, ny});
            }
        }
    }
}