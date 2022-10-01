class Solution {
    // (0, 0) (0, 1) (0, 2)
    // (1, 0) (1, 1) (1, 2)
    // (2, 0) (2, 1) (2, 2)
    
    public void rotate(int[][] matrix) {
        transpose(matrix);
        upsideDown(matrix);
    }
    
    void transpose(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length - i - 1; j++) {
                swap(matrix, i, j, matrix.length - j - 1, matrix.length - i - 1);
            }
        }
    }
    
    void upsideDown(int[][] matrix) {
        for(int i = 0; i < matrix.length / 2; i++) {
            for(int j = 0; j < matrix.length; j++) {
                swap(matrix, i, j, matrix.length - i - 1, j);
            }
        }
    }
    
    void swap(int[][] matrix, int a1, int a2, int b1, int b2) {
        int tmp = matrix[a1][a2];
        matrix[a1][a2] = matrix[b1][b2];
        matrix[b1][b2] = tmp;
    }
}