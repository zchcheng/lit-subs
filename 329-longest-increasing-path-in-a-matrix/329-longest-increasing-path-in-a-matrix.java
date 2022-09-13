class Solution {
    Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();
    
    public int longestIncreasingPath(int[][] matrix) {
        int res = 0;
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                res = Math.max(res, helper(matrix, new int[] { i, j }));
            }
        }
        
        return res;
    }
    
    int helper(int[][] matrix, int[] loc) {
        Pair<Integer, Integer> p = new Pair(loc[0], loc[1]);
        
        Integer res = memo.get(p);
        
        if (res != null) return res;
        
        res = 1;
        for(int[] n : new int[][] {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        }) {
            int nx = loc[0] + n[0];
            int ny = loc[1] + n[1];
            
            if (nx < 0 || ny < 0 || nx >= matrix.length || ny >= matrix[0].length) continue;
            if (matrix[nx][ny] >= matrix[loc[0]][loc[1]]) continue;
            
            res = Math.max(1 + helper(matrix, new int[] {nx, ny}), res);
        }
        
        memo.put(p, res);
        
        return res;
    }
}