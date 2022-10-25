class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        res = []
        n = len(nums)
        
        n1 = None
        for i in range(n - 3):
            if n1 == nums[i]: continue
            n1 = nums[i]    
            
            n2 = None
            for j in range(i + 1, n - 2):
                if n2 == nums[j]: continue
                n2 = nums[j]    
                t = target - n1 - n2
                l = j + 1
                r = n - 1
                
                while(l < r):
                    nl = nums[l]
                    nr = nums[r]
                    
                    if nl + nr == t:
                        res.append([n1, n2, nl, nr])
                        l += 1
                        r -= 1
                        while l < r and nr == nums[r]:
                            r -= 1
                    elif nl + nr < t:
                        l += 1
                        
                    else:
                        r -= 1
        
        return res
        