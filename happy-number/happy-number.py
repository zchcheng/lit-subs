class Solution:
    def isHappy(self, n: int) -> bool:
        seen = set()
        
        while n not in seen:
            seen.add(n)
            nx = 0
            while n > 0:
                mod = n % 10
                nx += mod ** 2
                n = n // 10
            n = nx

        return n == 1
