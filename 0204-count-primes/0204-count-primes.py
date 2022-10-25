class Solution:
    def countPrimes(self, n: int) -> int:
        if n == 0 or n == 1: return 0
        
        isPrime = [False, False] + [True] * (n - 2)
        
        for i in range(2, int(sqrt(n)) + 1):
            if isPrime[i]:
                for k in range(i * i, n, i):
                    isPrime[k] = False
            
        return sum(isPrime)