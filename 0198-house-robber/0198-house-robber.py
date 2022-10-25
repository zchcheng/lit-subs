class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [0, 0]
        
        for i in nums:
            n = max(dp[0] + i, dp[1])
            dp[0], dp[1] = dp[1], n
            
        return dp[1]