class Solution:
    def numPrimeArrangements(self, n: int) -> int:
        isPrime = [True] * (n + 1)
        np = 0
        
        for i in range(2, n + 1):
            if isPrime[i]:
                np += 1
                
                j = i
                while i * j <= n:
                    isPrime[i * j] = False
                    j += 1
                
        return (self.permutate(np) * self.permutate(n - np)) % (10 ** 9 + 7)
                
        
    def permutate(self, n):
        res = 1
        for i in range(1, n + 1):
            res *= i
        return res