class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long result = 0;
        int n = nums.length;
        
        int[] a1 = new int[n], a2 = new int[n], a3 = new int[n], a4 = new int[n];
        
        for(int i = n - 1, j = n, k = n, l = n, m = n; i >= 0; i--) {
            int g = nums[i];
            
            if (g > maxK) j = i;
            if (g < minK) l = i;
            if (g == maxK) k = i;
            if (g == minK) m = i;
            
            a1[i] = j;
            a2[i] = l;
            a3[i] = k;
            a4[i] = m;
        }
        
        for(int i = 0; i < n; i++) result += getCnt(i, Math.max(a3[i], a4[i]), Math.min(a1[i], a2[i]));
        
        return result;
    }
    
    long getCnt(int s, int e, int m) {
        if (e < s) return 0l;
        if (m < e) return 0l;
        return (long) m - e;
    }
}