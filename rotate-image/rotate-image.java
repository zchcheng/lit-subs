class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        upsideDown(matrix);
    }
    
    void upsideDown(int[][] matrix) {
        for(int r = 0; r < matrix.length / 2; r++) {
            for(int c = 0; c < matrix.length; c++) {
                swap(matrix, new int[] {r, c}, new int[] {matrix.length - 1 - r, c});
            }
        }
    }
    
    void transpose(int[][] matrix) {
        for(int r = 0; r < matrix.length; r++) {
            for(int c = 0; c < matrix.length - r; c++) {
                swap(matrix, new int[] {r, c}, new int[] { matrix.length - 1 - c, matrix.length - 1 - r });
            }
        }
    }
    
    void swap(int[][] matrix, int[] a, int[] b) {
        int tmp = matrix[a[0]][a[1]];
        matrix[a[0]][a[1]] = matrix[b[0]][b[1]];
        matrix[b[0]][b[1]] = tmp;
    }
}