class Solution:
    def firstUniqChar(self, s: str) -> int:
        q = []
        seen = {}
        
        for i in range(len(s)):
            c = s[i]
            if c not in seen:
                q.append(i)
            seen[c] = seen.get(c, 0) + 1
            
            while len(q) > 0 and seen.get(s[q[0]], 0) > 1:
                q.pop(0)
                
        if len(q) == 0:
            return -1
                
        return q[0]