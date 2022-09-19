class Solution {
    final int[][] dirs = new int[][] {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    
    void dfs(int[][] image, int sr, int sc, int color, int oriColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oriColor || image[sr][sc] == color) return;
        
        image[sr][sc] = color;
        
        for(int[] next : dirs) {
            int nr = sr + next[0];
            int nc = sc + next[1];
            
            dfs(image, nr, nc, color, oriColor);
        }
    }
}