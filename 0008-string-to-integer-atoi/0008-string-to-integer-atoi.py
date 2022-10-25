class Solution:
    def myAtoi(self, s: str) -> int:
        INT_MAX = 2**31 - 1
        INT_MIN = -2**31
        r = 0
        ptr = 0
        
        while ptr < len(s) and s[ptr] == ' ':
            ptr += 1
            
        neg = False
        
        if ptr < len(s) and (s[ptr] == '+' or s[ptr] == '-'):
            neg = s[ptr] == '-'
            ptr += 1
            
        while ptr < len(s):
            if not s[ptr].isdigit():
                break
                
            d = int(s[ptr])
            
            if r > int(INT_MAX / 10):
                return INT_MIN if neg else INT_MAX
            
            if r == int(INT_MAX / 10):
                if neg and d >= INT_MAX % 10 + 1:
                    return INT_MIN
                if not neg and d >= INT_MAX % 10:
                    return INT_MAX
                
            r = r * 10 + d
            ptr += 1
            
        return -r if neg else r
            