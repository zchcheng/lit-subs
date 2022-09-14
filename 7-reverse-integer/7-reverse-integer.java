class Solution {
    final int MAX = Integer.MAX_VALUE / 10;
    final int MAX_K = Integer.MAX_VALUE % 10;
    
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        
        int res = 0;
        boolean isNegative = x < 0;
        x = Math.abs(x);
        
        while(x > 0) {
            int k = x % 10;
            if (res > MAX || (res == MAX && k > MAX_K)) return 0;
            res = res * 10 + k;
            x = x / 10;
        }
        
        if (isNegative) res = -res;
        
        return res;
    }
}