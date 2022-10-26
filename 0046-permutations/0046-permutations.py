class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        s = set(nums)
        r = []
        self.helper([], s, r)
        return r
        
    def helper(self, current: List[int], nums: Set[int], res: List[List[int]]) -> None:
        if len(nums) == 0:
            res.append(current.copy())
            return 
        
        for n in nums:
            current.append(n)
            self.helper(current, set([x for x in nums if x != n]), res)
            current.pop()
        
        