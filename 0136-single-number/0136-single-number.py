class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        res = None
        for i in nums:
            if res is None:
                res = i
            else:
                res ^= i
        return res
