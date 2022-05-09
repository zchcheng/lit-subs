class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = 0;
        
        for(int i = 0, l = 0; i <= seats.length; i++) {
            if (i < seats.length && seats[i] == 0) {
                continue;
            }
            
            int d = dist(l, i - 1, seats.length);
            res = Math.max(res, d);
            l = i + 1;
        }
        
        return res;
    }
    
    int dist(int l, int r, int n) {
        if (l == 0) {
            return r + 1;
        }
        
        if (r == n - 1) {
            return r - l + 1;
        }
        
        int s = (r + l) / 2;
        
        return Math.min(s - l + 1, r - s + 1);
    }
}