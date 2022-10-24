class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        cur = 1
        for i in range(1, len(nums)):
            if nums[i - 1] != nums[i]:
                nums[cur] = nums[i]
                cur += 1
        return cur