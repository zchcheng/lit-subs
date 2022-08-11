class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        
        int n = 0;
        int k = x;
        
        while(k > 0) {
            n = n * 10 + k % 10;
            k /= 10;
        }
        
        return x == n;
    }
}