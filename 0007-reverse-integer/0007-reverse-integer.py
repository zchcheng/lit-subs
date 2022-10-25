class Solution:
    def reverse(self, x: int) -> int:
        int_max = int((2 ** 31 - 1) / 10)
        int_max_k = (2 ** 31 - 1) % 10
        int_min = int((-2 ** 31) / 10)
        int_min_k = int_max_k + 1
        res = 0
        
        while(x != 0):
            d = abs(x) % 10
            
            if res > int_max or (res == int_max and d >= int_max_k):
                return 0
            
            if res < int_min or (res == int_min and d >= abs(int_min_k)):
                return 0
            
            if x >= 0:
                res = res * 10 + d
            else:
                res = res * 10 - d
                
            x = int(x / 10)
            
        return res