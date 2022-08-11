class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        
        int[][] res = new int[r][c];
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (mat[i][j] == 0)  queue.offer(new int[] {i, j});
            }
        }
        
        int[][] dirs = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        
        while(!queue.isEmpty()) {
            int[] loc = queue.poll();
            int v = res[loc[0]][loc[1]];
            
            for(int[] dir : dirs) {
                int x = loc[0] + dir[0];
                int y = loc[1] + dir[1];
                
                if (x >= 0 && x < r && y >= 0 && y < c && mat[x][y] == 1 && res[x][y] == 0) {
                    queue.offer(new int[] {x, y});
                    res[x][y] = v + 1;
                }
            }
        }
        
        return res;
    }
}