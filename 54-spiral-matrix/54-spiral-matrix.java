class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        int s = 0;
        int[][] dir = new int[][] {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        
        int r = matrix.length;
        int c = matrix[0].length;
        int[] ep = new int[] {-1, r, -1, c};
        
        int total = r * c, i = 0, j = 0;
        while(res.size() < total) {
            res.add(matrix[i][j]);
            
            if (end(ep, i + dir[s][0], j + dir[s][1])) {
                s = (s + 1) % dir.length;
                int[] p = dir[s];
                ep[0] = Math.max(ep[0], ep[0] + p[0]);
                ep[1] = Math.min(ep[1], ep[1] + p[0]);
                ep[2] = Math.max(ep[2], ep[2] + p[1]);
                ep[3] = Math.min(ep[3], ep[3] + p[1]);
            }
            
            i += dir[s][0];
            j += dir[s][1];
        }
        
        return res;
    }
    
    boolean end(int[] ep, int i, int j) {
        return i <= ep[0] || i >= ep[1] || j <= ep[2] || j >= ep[3];
    }
}