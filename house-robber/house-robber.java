class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        
        for(int i = 1; i < n; i++) {
            dp[i + 1] = Math.max(dp[i], nums[i] + dp[i - 1]);
        }
        
        return dp[nums.length];
    }
}