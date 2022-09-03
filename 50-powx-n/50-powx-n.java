class Solution {
    public double myPow(double x, int n) {
        return helper(x, n);
    }
    
    double helper(double x, long n) {
        if (n == 0) return 1.0;
        if (n == 1) return x;
        if (n < 0) return helper(1 / x, -n);
        double half = helper(x, n / 2);
        return half * half * ((n % 2 == 0)? 1 : x);
    }
}