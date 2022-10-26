class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [1] * n
        
        m = 1
        for i in range(n):
            res[i] *= m
            m *= nums[i]
            
        m = 1   
        for i in range(n - 1, -1, -1):
            res[i] *= m
            m *= nums[i]
                
        return res