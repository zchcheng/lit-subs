class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        seen = {}
        l = -1
        
        for i, c in enumerate(s):
            l = max(l, seen.get(c, -1))
            res = max(res, i - l)
            seen[c] = i
                
        return res
        