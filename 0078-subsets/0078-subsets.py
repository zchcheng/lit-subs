class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.helper(0, nums, [], res)
        return res
        
        
    def helper(self, i: int, nums: List[int], cur: List[int], res: List[List[int]]) -> None:
        if i >= len(nums):
            res.append(cur[:])
            return
        
        self.helper(i + 1, nums, cur, res)
        cur.append(nums[i])
        self.helper(i + 1, nums, cur, res)
        cur.pop()