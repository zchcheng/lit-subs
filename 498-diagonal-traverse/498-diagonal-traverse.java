class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int r = mat.length;
        
        if (r == 0) return new int[0];
        
        int c = mat[0].length;
        
        int[] res = new int[r * c];
        
        for(int i = 0, idx = 0; i < r + c - 1; i++) {
            int j = (i % 2 == 0)? Math.min(i, r - 1) : 0 + Math.max(0, i - c + 1);
            int d = (i % 2 == 0)? -1 : 1;
            
            for(; j >= 0 && j < r && i - j >= 0 && i - j < c; j += d) {
                res[idx++] = mat[j][i - j];
            }
        }
        
        return res;
    }
}