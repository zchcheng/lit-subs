class Solution {
    public boolean validPalindrome(String s) {
        return helper(s, true);
    }
    
    boolean helper(String s, boolean hasChance) {
        char[] charArr = s.toCharArray();
        int n = charArr.length;
        
        for(int i = 0; i < n / 2; i++) {
            if (charArr[i] != charArr[n - i - 1]) {
                if (!hasChance) return false;
                
                return helper(s.substring(i, n - i - 1), false) || helper(s.substring(i + 1, n - i), false);
            }
        }
        
        return true;
    }
}