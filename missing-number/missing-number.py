class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        
        for i in range(n):
            k = abs(nums[i])
            if k == n + 1:
                k = 0
                
            if k >= n:
                continue
                
            if nums[k] == 0:
                nums[k] = - n - 1
            else:
                nums[k] = -abs(nums[k])
                
        for i, j in enumerate(nums):
            if j >= 0:
                return i
            
        return n