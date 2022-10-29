class Solution:
    def countDigitOne(self, n: int) -> int:
        if n == 0:return 0
        res = 0
        for i in range(int(log10(n)) + 1):
            k = 10 ** (i + 1)
            res += (n // k) * (k // 10) + min(max(n % k - (k // 10) + 1, 0), k // 10)
            
        return res
            
            
        