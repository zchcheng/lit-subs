class Solution:
    def minWindow(self, s: str, t: str) -> str:
        cnt = collections.Counter(t)
        lack = sum(cnt.values())
        current = collections.defaultdict(lambda: 0)
        
        l, res = 0, ''
        
        for i in range(len(s)):
            c = s[i]
            
            if c not in cnt:
                continue
                
            current[c] += 1
            
            if current[c] <= cnt[c]:
                lack -= 1
                
            while lack <= 0:
                if not res or len(res) > i - l + 1:
                    res = s[l:i + 1]
                if s[l] in cnt:
                    current[s[l]] -= 1
                    if current[s[l]] < cnt[s[l]]:
                        lack += 1
                l += 1
        
        return res
        