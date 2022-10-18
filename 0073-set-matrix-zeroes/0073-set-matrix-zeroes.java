class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        // elements in the first row should be zero
        boolean fr = false;
        
        // elements in the first col should be zero
        boolean fc = false;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < r; i++) {
            if (matrix[i][0] != 0) continue;
            for(int j = 0; j < c; j++) matrix[i][j] = 0;
        }
        
        for(int i = 1; i < c; i++) {
            if (matrix[0][i] != 0) continue;
            for(int j = 0; j < r; j++) matrix[j][i] = 0;
        }
        
        if (fr) for(int i = 0; i < c; i++) matrix[0][i] = 0;
        if (fc) for(int i = 0; i < r; i++) matrix[i][0] = 0;
    }
}