class Solution:
    def checkSubarraySum(self, nums: List[int], k: int) -> bool:
        seen, s, n = {0: -1}, 0, len(nums)
        
        for i in range(n):
            s = (s + nums[i]) % k
            
            if s in seen:
                if seen[s] < i - 1:
                    return True
            else:
                seen[s] = i
                
        return False
                
            
            
        
        
            
        
        