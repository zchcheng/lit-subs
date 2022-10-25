class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        lps = self.buildLPS(needle)
        
        idx = 0
        for i, c in enumerate(haystack):
            idx = self.findIndex(needle, idx, lps, haystack[i])
            if idx == len(needle):
                return i - len(needle) + 1
        
        return -1
    
    def findIndex(self, s: str, idx: int, lps: List[int], c: str) -> int:
        while idx >= 0:
            if s[idx] == c:
                return idx + 1
            
            if idx == 0:
                return 0
            
            idx = lps[idx - 1] + 1
            
        return 0
            
        
    def buildLPS(self, s: str) -> List[int]:
        n = len(s)
        lps = [-1] * n
        
        for i in range(1, n):
            idx = lps[i - 1] + 1
            
            while(idx >= 0):
                if s[idx] == s[i]:
                    break
                if idx == 0:
                    idx = -1
                else:
                    idx = lps[idx - 1] + 1
                    
            lps[i] = idx
            
        return lps
        