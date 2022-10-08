class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = 0, r = (int)10e9;
        
        if (bloomDay.length < m * k) return -1;
        
        while(l <= r) {
            int md = l + (r - l) / 2;
            
            if (canDo(bloomDay, m, k, md)) r = md - 1;
            else l = md + 1;
        }
        
        return l;
    }
    
    boolean canDo(int[] bd, int m, int k, int d) {
        int sum = 0;
        
        for(int i = 0, prev = 0; i < bd.length; i++) {
            if (bd[i] > d) {
                prev = i + 1;
                continue;
            }
            
            if (i - prev + 1 >= k) { 
                sum++;
                prev = i + 1;
            }
        }
        
        return sum >= m;
    }
}