class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        r = []
        self.helper(0, nums, r)
        return r
        
    def helper(self, n: int, nums: List[int], res: List[List[int]]) -> None:
        if n == len(nums):
            res.append(nums[:])
            return 
        
        for i in range(n, len(nums)):
            nums[i], nums[n] = nums[n], nums[i]
            self.helper(n + 1, nums, res)
            nums[i], nums[n] = nums[n], nums[i]
        
        