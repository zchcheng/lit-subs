class Solution:
    def minWindow(self, s: str, t: str) -> str:
        l = -1
        cnt = collections.Counter(t)
        lack = len(t)
        res = None
        
        for i, c in enumerate(s):
            if c not in cnt: continue
            cnt[c] -= 1
            if cnt[c] >= 0:
                lack -= 1
                
            while l < i and lack == 0:
                if not res or i - l < len(res):
                    res = s[l + 1 : i + 1]
                l += 1    
                if s[l] not in cnt: continue
                cnt[s[l]] += 1
                if cnt[s[l]] > 0:
                    lack += 1
                    
        return '' if not res else res
            