class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        idx = self.check(nums)
        
        if idx == len(nums):
            return True
        
        return (self.check(nums[:idx - 1] + nums[idx:]) == len(nums) - 1) or (self.check(nums[:idx] + nums[idx + 1:]) == len(nums) - 1)
        
    
    def check(self, arr) -> int:
        i = 0
        
        cur = -999999
        while i < len(arr):
            if arr[i] < cur:
                break
            cur = arr[i]
            i += 1
            
        return i
