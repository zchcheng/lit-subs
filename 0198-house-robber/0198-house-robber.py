class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [0, 0]
        
        for i in nums:
            dp[0], dp[1] = dp[1], max(dp[0] + i, dp[1])
            
        return dp[1]