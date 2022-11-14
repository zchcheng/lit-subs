class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        m = {}
        
        l, res = -1, 0
        for c, i in zip(s, range(len(s))):
            if c in m:
                l = max(m[c], l)
            res = max(res, i - l)
            m[c] = i
            
        return res
            
            