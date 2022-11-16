class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        m = {}
        seen = set()
        
        for i in range(len(s)):
            cs = s[i]
            ct = t[i]
            
            if cs not in m:
                if ct in seen: return False
                m[cs] = ct
                seen.add(ct)
            else:
                if m[cs] != ct:
                    return False
                
        return True