class Solution {
    int[] ns = null;
    int[] ct = null; 
    
    public long minCost(int[] nums, int[] cost) {
        long mm = Long.MAX_VALUE;
        long mx = Long.MIN_VALUE;
        
        ns = nums;
        ct = cost;
        
        for(int n : nums) {
            mm = Math.min(mm, n);
            mx = Math.max(mx, n);
        }
        
        while(mm < mx) {
            long m = mm + (mx - mm) / 2l;
            
            long m1 = m + 1;
            long m2 = m - 1;
            
            long c1 = getCost(m1);
            long c2 = getCost(m2);
            long c = getCost(m);
            
            if (c < c1 && c < c2) return c;
            if (c >= c1 & c <= c2) { mm = m1; } 
            else { mx = m2; }
        }
        
        return getCost(mm);
    }
    
    
    long getCost(long m) {
        long r = 0;
        for(int i = 0; i < ns.length; i++) {
            r += (long)(Math.abs(ns[i] - m)) * (long)ct[i];
        }
        return r;
    }
}