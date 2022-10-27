class Solution:
    def decodeString(self, s: str) -> str:
        res = ''
        
        idx = 0
        times = 0
        
        while idx < len(s):
            c = s[idx]
            if c.isdigit():
                times = times * 10 + int(c)
            elif c == '[':
                j = idx + 1
                st = 1
                while st > 0:
                    if s[j] == ']': st -= 1
                    elif s[j] == '[': st += 1
                    if st != 0: j += 1
                subs = self.decodeString(s[idx + 1 : j])
                for _ in range(times):
                    res += subs
                times = 0    
                idx = j
            else:
                res += c
            idx += 1
        return res
            
                
                
        
        