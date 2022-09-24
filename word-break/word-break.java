class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        
        for(int i = dp.length - 1; i >= 0; i--) {
            for(String w : wordDict) {
                int len = dp.length - i;
                
                if (w.length() > len) continue;
                
                if (w.length() == len) {
                    dp[i] |= s.substring(i).equals(w);
                    continue;
                }
                
                dp[i] |= s.substring(i, i + w.length()).equals(w) && dp[i + w.length()];
            }
        }
        
        return dp[0];
    }
}