class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        n = len(nums)
        i = 0
        j = n
        
        s = 0
        
        while s < x and j > i:
            j -= 1
            s += nums[j]
            
        
        res = -1 if j <= i or s != x else n - j
        
        if j == i and s < x:
            return res
        
        print(j)
        print(res)
        
        while i < n:
            s += nums[i]
            i += 1
            
            while s > x and j < n:
                s -= nums[j]
                j += 1
                
            k = i + n - j
            if s == x:
                if res == -1: res = k
                else: res = min(res, k)
                    
        return res
                
        
        
