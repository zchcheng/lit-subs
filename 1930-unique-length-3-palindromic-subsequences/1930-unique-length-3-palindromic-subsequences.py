class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        last = {}
        
        for i in range(len(s) - 1, -1, -1):
            c = s[i]
            last[c] = max(last.get(c, i), i)
                
        seen = set()
        res = 0
        for i in range(len(s)):
            if s[i] in seen:
                continue
                
            unique = set()
            for j in range(i + 1, last[s[i]]):
                unique.add(last[s[j]])
                
            res += len(unique)
            seen.add(s[i])
                
        return res
        