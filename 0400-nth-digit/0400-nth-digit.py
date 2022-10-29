class Solution:
    def findNthDigit(self, n: int) -> int:
        k = 0
        
        while n > (10 ** k) * 9 * (k + 1):
            n -= (10 ** k) * 9 * (k + 1)
            k += 1
            
        m = (n - 1) // (k + 1)
        l = n % (k + 1)
        
        return str(10 ** k + m)[l - 1]
        
            
        