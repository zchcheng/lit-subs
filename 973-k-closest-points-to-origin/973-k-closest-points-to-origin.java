class Solution {
    int[][] points;
    
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][0];
        this.points = points;
        
        quickSelect(0, points.length - 1, k - 1);
        
        for(int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        
        return res;
    }
    
    void quickSelect(int start, int end, int k) {
        int p = partition(start, end);
        
        if (p == k) {
            return;
        }
        
        if (p < k) {
            quickSelect(p + 1, end, k);
        } else {
            quickSelect(start, p - 1, k);
        }
    }
    
    int partition(int start, int end) {
        int v = getValue(points[start]);
        int j = start + 1;
        
        for(int i = start + 1; i <= end; i++) {
            int c = getValue(points[i]);
            if (c < v) {
                swap(i, j++);
            }
        }
        
        swap(start, j - 1);
        
        return j - 1;
    }
    
    int getValue(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
    
    void swap(int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}