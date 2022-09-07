class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int res = 0;
        
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') continue;
            
            if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                dp[i] = (((i - 2 - dp[i - 1]) >= 0)? dp[i - 2 - dp[i - 1]] : 0) + dp[i - 1] + 2;
                res = Math.max(res, dp[i]);
            }
        }
        
        return res;
    }
}