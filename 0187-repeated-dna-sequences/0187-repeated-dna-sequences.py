class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        seen = set()
        res = set()
        n = len(s)
        
        cur = ''
        for i in range(n):
            cur += s[i]
            
            if len(cur) < 10:
                continue
                
            if len(cur) > 10:
                cur = cur[1:]
                
            if cur in seen and cur not in res:
                res.add(cur)
            
            seen.add(cur)
            
        return list(res)
        
        