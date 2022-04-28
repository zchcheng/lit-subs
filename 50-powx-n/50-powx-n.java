class Solution {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n == -1) return 1/x;
        
        double h = myPow(x, n / 2);
        
        return h * h * myPow(x, n % 2); 
    }
}