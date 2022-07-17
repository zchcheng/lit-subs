class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        int cycle = n / 2;
        int initCnt = n - 1;
        
        for(int i = 0; i < cycle; i++) {
            
            for(int j = 0; j < initCnt; j++) {
                int v1 = matrix[i][i + j];
                int v2 = matrix[i + j][n - 1 - i];
                int v3 = matrix[n - 1 - i][n - 1 - i - j];
                int v4 = matrix[n - 1 - i - j][i];
                
                matrix[i][i + j] = v4;
                matrix[i + j][n - 1 - i] = v1;
                matrix[n - 1 - i][n - 1 - i - j] = v2;
                matrix[n - 1 - i - j][i] = v3;
            }
            
            initCnt -= 2;
        }
    }
}