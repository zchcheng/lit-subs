class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        i = self.findDecreasing(nums)
        
        if i > 0:
            j = self.findGreaterEl(nums, i - 1)    
            nums[i - 1], nums[j] = nums[j], nums[i - 1]
            
        self.reverse(nums, i, len(nums) - 1)
        
        
    def findDecreasing(self, nums):
        for i in range(len(nums) - 1, 0, -1):
            if nums[i] > nums[i - 1]:
                return i
        return 0
        

    def findGreaterEl(self, nums, i):
        res = i + 1
        
        for j in range(i + 1, len(nums)):
            if nums[j] <= nums[res] and nums[j] > nums[i]:
                res = j
                
        return res
        
        
    def reverse(self, nums, i, j):
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1
