class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] row = searchForRow(matrix, target);
        return exist(row, target);
    }
    
    int[] searchForRow(int[][] matrix, int target) {
        int s = 0;
        int e = matrix.length - 1;
        
        while(s <= e) {
            int m = s + (e - s) / 2;
            int[] r = matrix[m];
            
            if (target >= r[0] && target <= r[r.length - 1]) return r;
            
            if (target < r[0]) e = m - 1;
            else s = m + 1;
        }
        
        return null;
    }
    
    boolean exist(int[] row, int target) {
        if (row == null) return false;
        
        int s = 0;
        int e = row.length - 1;
        
        while(s <= e) {
            int m = s + (e - s) / 2;
            
            if (row[m] == target) return true;
            
            if (row[m] < target) s = m + 1;
            else e = m - 1;
        }
        
        return false;
    }
}