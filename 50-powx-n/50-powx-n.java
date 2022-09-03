class Solution {
    public double myPow(double x, int n) {
        x = (n >= 0)? x : 1 / x;
        long N = n;
        N = (N >= 0)? N : -N;
        
        double res = 1;
        double cur = x;
        
        for(long i = N; i > 0; i >>= 1) {
            if (i % 2 != 0) res = res * cur;
            cur = cur * cur;
        }
        
        return res;
    }
}