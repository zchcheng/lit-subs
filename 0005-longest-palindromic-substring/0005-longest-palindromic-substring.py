class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ''
        
        for i in range(len(s)):
            l1, r1 = self.helper(s, i, i + 1)
            l2, r2 = self.helper(s, i, i)
            
            len1 = r1 - l1 - 1
            len2 = r2 - l2 - 1
            
            if len1 > len2 and len1 > len(res):
                res = s[l1 + 1 : r1]
            if len2 > len1 and len2 > len(res):
                res = s[l2 + 1 : r2]
                
        return res
            
    def helper(self, s, i, j):
        while i >= 0 and j < len(s):
            if s[i] != s[j]:
                break
            i -= 1
            j += 1
            
        return (i, j)
            
        
