class Solution {
    public int reverse(int x) {
        int result = 0;
        
        final int K = (x >= 0)? Integer.MAX_VALUE / 10 : Integer.MIN_VALUE / 10;
        final int KD = (x >= 0)? Integer.MAX_VALUE % 10 : Integer.MIN_VALUE % 10;
        
        while(x != 0) {
            int d = x % 10;
            if (result < 0 && (result < K || (result == K && d < KD))) return 0;
            if (result > 0 && (result > K || (result == K && d > KD))) return 0;
            
            result = result * 10 + d;
            
            x /= 10;
        }
        
        return result;
    }
}