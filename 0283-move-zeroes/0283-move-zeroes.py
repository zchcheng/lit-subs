class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                self.swap(nums, i, j)
                j += 1
        
        
    def swap(self, nums, a, b):
        tmp = nums[a]
        nums[a] = nums[b]
        nums[b] = tmp