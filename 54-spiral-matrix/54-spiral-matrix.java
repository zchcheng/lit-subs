class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        
        int s = 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int total = r * c;
        int[][] dir = new int[][] { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };
        int[] corner = new int[] {-1, r, -1, c};
        
        int i = 0, j = 0;
        while(res.size() < total) {
            
            res.add(matrix[i][j]);
            
            if (end(corner, i + dir[s][0], j + dir[s][1])) {
                s = (s + 1) % dir.length;
                int[] p = dir[s];
                corner[0] = Math.max(corner[0], corner[0] + p[0]);
                corner[1] = Math.min(corner[1], corner[1] + p[0]);
                corner[2] = Math.max(corner[2], corner[2] + p[1]);
                corner[3] = Math.min(corner[3], corner[3] + p[1]);
            }
            
            i += dir[s][0];
            j += dir[s][1];
        }
        
        return res;
    }
    
    boolean end(int[] corner, int i, int j) {
        return i <= corner[0] || i >= corner[1] || j <= corner[2] || j >= corner[3];
    }
}