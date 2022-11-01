class Solution:
    def maxSubArrayLen(self, nums: List[int], k: int) -> int:
        longest = 0
        occurence = {0: -1}
        
        s = 0
        for i in range(len(nums)):
            n = nums[i]
            s += n
            t = s - k
            
            if t in occurence:
                longest = max(longest, i - occurence[t])
                
            if s not in occurence:
                occurence[s] = i
                
        return longest
        
        