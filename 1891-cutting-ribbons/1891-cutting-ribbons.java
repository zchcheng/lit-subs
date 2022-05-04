class Solution {
    public int maxLength(int[] ribbons, int k) {
        long sum = 0;
        for(long r : ribbons) sum += r;
        
        if (k > sum) return 0;
        
        long start = 1;
        long end = sum;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            long r = numOfRibbon(ribbons, mid);
            if (r < k) { end = mid - 1; } 
            else { start = mid + 1; }
        }
        
        return (int)end;
    }
    
    long numOfRibbon(int[] ribbons, long len) {
        long res = 0;
        
        for(long r : ribbons) {
            res += r / len;
        }
        
        return res;
    }
}