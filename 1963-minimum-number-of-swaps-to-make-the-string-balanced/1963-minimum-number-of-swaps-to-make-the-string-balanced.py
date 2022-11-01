class Solution:
    def minSwaps(self, s: str) -> int:
        i = 0 
        j = len(s) - 1
        hst = 0
        tst = 0
        
        res = 0
        while i < j:
            while i <= j and hst >= 0:
                hst += 1 if s[i] == '[' else -1
                if hst >= 0: i += 1
                
            while i <= j and tst >= 0:
                tst += 1 if s[j] == ']' else -1
                if tst >= 0: j -= 1
                
            print(str(i) + ', ' + str(j))
                
            if i <= j:
                res += 1
                i += 1
                j -= 1
                
            hst = max(1, hst)
            tst = max(1, tst)
                
        return res
                
            
                
            
                
        