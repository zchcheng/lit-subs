class Solution:
    def wiggleSort(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        copy = nums[:]
        copy.sort(key = lambda x: x)
        
        j = 0
        for i in range(len(nums)):
            nums[j] = copy[i]
            j += 2
            if j >= len(nums):
                j = 1
