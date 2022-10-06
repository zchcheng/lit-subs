class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = findRow(matrix, target);
        
        if (r < 0) return false;
        
        int c = findCol(matrix, r, target);
        
        return c >= 0;
    }
    
    int findRow(int[][] matrix, int target) {
        int l = 0, r = matrix.length - 1;
        
        while(l <= r) {
            int m = l + (r - l) / 2;
            
            int rl = matrix[m][0];
            int rr = matrix[m][matrix[m].length - 1];
           
            if (rl <= target && target <= rr) return m;
            
            if (rl > target) r = m - 1;
            else l = m + 1;
        }
        
        return -1;
    }
    
    int findCol(int[][] matrix, int row, int target) {
        int l = 0, r = matrix[row].length - 1;
        
        while(l <= r) {
            int m = l + (r - l) / 2;
            
            if (matrix[row][m] == target) return m;
            
            if (matrix[row][m] < target) l = m + 1;
            else r = m - 1;
        }
        
        return -1;
    }
}