class Solution {
    int[] prefixSum;
    int n;

    public Solution(int[] w) {
        n = w.length;
        prefixSum = new int[n];
        
        for(int i = 0, sum = 0; i < n; i++) {
            sum += w[i];
            prefixSum[i] = sum;
        }
    }
    
    public int pickIndex() {
        double r = prefixSum[n - 1] * Math.random();
        return search(r);
    }
    
    int search(double r) {
        int start = 0;
        int end = n - 1;
        
        while(start < end) {
            int mid = (start + end) / 2;
            int v = prefixSum[mid];
            
            if (r <= v) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return start;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */