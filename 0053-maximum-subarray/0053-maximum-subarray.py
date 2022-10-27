class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        v = float('-inf')
        
        s = 0
        for n in nums:
            s += n
            v = max(v, s)
            s = max(s, 0)
            
        return v