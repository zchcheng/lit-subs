class Solution {
    public int reverse(int x) {
        int k = x;
        int res = 0;
        
        // res * 10 + (k % 10) > Integer.MAX
        // res * 10 > Integer.MAX - (k % 10)
        // res >
        
        while(k != 0) {
            if (x > 0 && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && k % 10 > 7))) return 0;
            if (x < 0 && (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && k % 10 > 8))) return 0;
            res = res * 10 + k % 10;
            if (res > 0 && x < 0) res = -res;
            k /= 10;
        }
        
        return res;
    }
}