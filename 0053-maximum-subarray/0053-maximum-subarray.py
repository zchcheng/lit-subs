class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        r = float('-inf')
        s = 0
        
        for i in nums:
            s += i
            r = max(r, s)
            s = max(s, 0)
        
        return r