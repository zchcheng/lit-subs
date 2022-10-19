class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[] r = new int[] {0, 1};
        
        boolean[][] dp = new boolean[n + 1][n];
        
        Arrays.fill(dp[0], true);
        Arrays.fill(dp[1], true);
        
        for(int i = 2; i <= n; i++) {
            for(int j = i - 1; j < n; j++) {
                dp[i][j] = dp[i - 2][j - 1] && s.charAt(j) == s.charAt(j - i + 1);
                if (dp[i][j]) {
                    r[0] = j - i + 1;
                    r[1] = j + 1;
                }
            }
        }
            
        return s.substring(r[0], r[1]);
    }
}