class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        
        Arrays.fill(dp, -1);
        dp[0] = 0;
        
        for(int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            boolean found = false;
            
            for(int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i >= coin && dp[i - coin] != -1) {
                    min = Math.min(min, dp[i - coin] + 1);
                    found = true;
                }
            }
            
            if (found) dp[i] = min;
        }
        
        return dp[amount];
    }
}