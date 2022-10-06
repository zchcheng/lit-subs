class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Integer.MAX_VALUE;
        
        while(l < r) {
            int m = l + (r - l) / 2;
            
            int needHours = totalHours(piles, m);
            
            if (needHours > h) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return l;
    }
    
    int totalHours(int[] piles, int bps) {
        int result = 0;
        
        for(int p : piles) {
            result += (p + bps - 1) / bps;
        }
        
        return result;
    }
}