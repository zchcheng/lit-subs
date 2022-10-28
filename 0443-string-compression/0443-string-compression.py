class Solution:
    def compress(self, chars: List[str]) -> int:
        res = 0
        cur = None
        cnt = 0
        
        def update():
            nonlocal res
            if cur and cnt:
                chars[res] = cur
                res += 1
                if cnt > 1:
                    for sc in str(cnt):
                        chars[res] = sc
                        res += 1
        
        for i in range(len(chars)):
            c = chars[i]
            
            if cur and cur == c:
                cnt += 1
                continue
                
            update()
            cur = c
            cnt = 1
            
        update()
                
        return res
                
                