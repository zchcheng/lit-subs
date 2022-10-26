class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [0] * n
        
        i = 0
        j = n - 1
        
        for k in range(n - 1, -1, -1):
            a = nums[i] ** 2
            b = nums[j] ** 2
            
            if a > b:
                res[k] = a
                i += 1
            else:
                res[k] = b
                j -= 1
        
        return res