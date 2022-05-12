class Solution {
    public int getFood(char[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        
        int res = 0;
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (grid[i][j] == '*') {
                    q.offer(new int[] {i, j});
                    visited[i][j] = true;
                    break;
                }
            }
            if (!q.isEmpty()) break;
        }
        
        int[][] mv = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i = 0; i < sz; i++) {
                int[] p = q.poll();
                
                for(int[] n : mv) {
                    int nx = p[0] + n[0];
                    int ny = p[1] + n[1];
                    if (nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny] || grid[nx][ny] == 'X') continue;
                    if (grid[nx][ny] == '#') return res + 1;
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;
                }
            }
            res++;
        }
        
        return -1;
    }
}