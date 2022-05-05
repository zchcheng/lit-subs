class Solution {
    String r = "";
    Boolean[][] memo = null;
    String s;
    
    public String longestPalindrome(String s) {
        int n = s.length();
        memo = new Boolean[n][n];
        this.s = s;
        
        for(int i = 0; i < n; i++) 
            for(int j = 0; j < n; j++)
                helper(i, j);
        
        return r;
    }
    
    boolean helper(int i, int j) {
        if (i > j) return true;
        
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        
        boolean res = (s.charAt(i) == s.charAt(j) && helper(i + 1, j - 1));
        memo[i][j] = res;
        
        if (res && (j - i + 1) > r.length()) { 
            r = s.substring(i, j + 1);
        }
        
        return res;
    }
}