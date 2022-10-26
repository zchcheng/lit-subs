class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        res = len(nums)
        for i, j in enumerate(nums):
            res ^= i ^ j
        return res
