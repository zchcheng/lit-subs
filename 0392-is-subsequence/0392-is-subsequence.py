class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if not s: return True
        
        ptr = 0
        
        for i in range(len(t)):
            if t[i] == s[ptr]:
                ptr += 1
                if ptr >= len(s): return True
                
        return ptr >= len(s)
            
