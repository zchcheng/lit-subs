class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        stack = []
        
        n = len(s)
        idx = 0
        while idx < n:
            c = s[idx]
            
            if stack and stack[-1][0] == c:
                _, cnt = stack.pop()
                if cnt < k - 1:
                    stack.append((c, cnt + 1))
            else:
                stack.append((c, 1))
                
            idx += 1
                
        res = ''
        while stack:
            c, t = stack.pop(0)
            for _ in range(t):
                res += c
                
        return res
                
            