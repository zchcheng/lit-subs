class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        s = sum(nums)
        
        cur = 0
        for i in range(len(nums)):
            if cur * 2 == s - nums[i]:
                return i
            cur += nums[i]
            
        return -1
            