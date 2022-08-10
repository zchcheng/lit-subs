class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oriClr = image[sr][sc];
        
        if (oriClr == color) return image;
        
        int[][] next = new int[][] {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sr, sc});
        
        while(!queue.isEmpty()) {
            int[] loc = queue.poll();
            
            image[loc[0]][loc[1]] = color;
            
            for(int[] n : next) {
                int nr = loc[0] + n[0];
                int nc = loc[1] + n[1];
                
                if (nr < 0 || nc < 0 || nr >= image.length || nc >= image[0].length || image[nr][nc] != oriClr) {
                    continue;
                }
                
                queue.offer(new int[] {nr, nc});
            }
        }
        
        return image;
    }
}