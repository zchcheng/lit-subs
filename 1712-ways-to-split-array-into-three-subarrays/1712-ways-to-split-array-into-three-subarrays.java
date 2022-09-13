class Solution {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int k = (int)1e9 + 7;
        
        for(int i = 0, sum = 0; i < n; i++) {
            sum += nums[i];
            prefixSum[i] = sum;
        }
        
        int res = 0;
        
        for(int i = n - 3; i >= 0; i--) {
            if (prefixSum[i] * 2 > prefixSum[n - 1] - prefixSum[i]) continue;
            
            int min = binSearch(prefixSum, i, true);
            int max = binSearch(prefixSum, i, false);
            
            if (min > max) continue;
            
            res = (res + (max - min + 1) % k) % k;
        }
        
        return res;
    }
    
    int binSearch(int[] prefixSum, int lb, boolean searchLeft) {
        int l = lb + 1;
        int r = prefixSum.length - 2;
        
        int sl = prefixSum[lb];
        
        while(l <= r) {
            int m = l + (r - l) / 2;
            
            int sm = prefixSum[m] - prefixSum[lb];
            int sr = prefixSum[prefixSum.length - 1] - prefixSum[m];
            
            if (sl <= sm && sm <= sr) {
                if (searchLeft) r = m - 1;
                else l = m + 1;
            } 
            else if (sm < sl) l = m + 1;
            else r = m - 1;
        }
        
        return (searchLeft)? l : r;
    }
}