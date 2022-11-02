class Solution:
    def maxProduct(self, s: str) -> int:
        n, pals = len(s), {}
        
        for i in range(1, 1 << n):
            sub = ''
            for j in range(n):
                mask = 1 << j
                if mask & i:
                    sub += s[j]
                    
            if sub == sub[::-1]:
                pals[i] = len(sub)
                
        res = 1
        for i, il in pals.items():
            for j, jl in pals.items():
                if i & j:
                    continue
                    
                res = max(res, il * jl)
                
        return res

                