class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int r = mat.length;
        
        if (r == 0) return new int[0];
        
        int c = mat[0].length;
        
        int[] res = new int[r * c];
        
        for(int i = 0, idx = 0; i < r + c - 1; i++) {
            int j = (i % 2 == 0)? i : 0;
            int d = (i % 2 == 0)? -1 : 1;
            int k = (i % 2 == 0)? -1 : i + 1;
            
            while(j != k) {
                if (j < r && i - j < c) res[idx++] = mat[j][i - j];
                j += d;
            }
        }
        
        return res;
    }
}