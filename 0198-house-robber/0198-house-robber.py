class Solution:
    def rob(self, nums: List[int]) -> int:
        dp_1 = 0
        dp_2 = 0
        
        for i in nums:
            n = max(dp_1, dp_2 + i)
            dp_2 = dp_1
            dp_1 = n
            
        return dp_1