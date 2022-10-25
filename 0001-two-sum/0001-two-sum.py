class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        seen = {}
        
        for i in range(len(nums)):
            n = nums[i]
            if ((target - n) in seen):
                return [i, seen[target - n]]
            seen[n] = i
            
        return [-1, -1]