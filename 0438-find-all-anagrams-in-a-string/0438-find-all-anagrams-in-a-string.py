class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        cnt, lack, n = collections.Counter(p), len(p), len(s)
        
        res = []
        for i in range(n):
            c = s[i]
            
            if c in cnt:
                cnt[c] -= 1
                if cnt[c] >= 0:
                    lack -= 1
                
            if i >= len(p):
                r = s[i - len(p)]
                if r in cnt:
                    cnt[r] += 1
                    if cnt[r] > 0:
                        lack += 1
                        
            if lack == 0:
                res.append(i - len(p) + 1)
                
        return res