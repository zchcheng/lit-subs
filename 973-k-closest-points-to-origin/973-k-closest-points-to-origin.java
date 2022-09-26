class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, 0, points.length - 1, k - 1);
        
        int[][] result = new int[k][2];
        
        for(int i = 0; i < k; i++) result[i] = points[i];
        
        return result;
    }
    
    void quickSelect(int[][] arr, int l, int r, int k) {
        int idx = partition(arr, l, r);
        
        if (idx == k) return;
        
        if (idx > k) quickSelect(arr, l, idx - 1, k);
        else quickSelect(arr, idx + 1, r, k);
    }
    
    int partition(int[][] arr, int l, int r) {
        int pivot = cal(arr[l]);
        
        int j = l + 1;
        for(int i = l + 1; i <= r; i++) {
            int v = cal(arr[i]);
            if (v <= pivot) swap(arr, i, j++);
        }
        
        swap(arr, l, j - 1);
        
        return j - 1;
    }
    
    void swap(int[][] arr, int a, int b) {
        int[] tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    
    int cal(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}