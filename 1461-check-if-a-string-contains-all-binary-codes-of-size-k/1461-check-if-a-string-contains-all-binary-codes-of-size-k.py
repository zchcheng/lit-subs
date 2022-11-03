class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        total = 2 ** k
        
        cur = ''
        seen = set()
        for i in range(len(s)):
            cur += s[i]
            
            if i >= k:
                cur = cur[1:]
                
            if i >= k - 1:
                seen.add(cur)
                
        return len(seen) >= total
                
            