class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        Set<Integer> zrs = new HashSet<>();
        Set<Integer> zcs = new HashSet<>();
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    zrs.add(i);
                    zcs.add(j);
                }
            }
        }
        
        for(int R : zrs) {
            for(int i = 0; i < c; i++) matrix[R][i] = 0;
        }
        
        for(int C : zcs) {
            for(int i = 0; i < r; i++) matrix[i][C] = 0;
        }
    }
}