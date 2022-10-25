class Solution:
    def climbStairs(self, n: int) -> int:
        n_0 = 1
        n_1 = 1
        
        for i in range(2, n + 1):
            s = n_0 + n_1
            n_0 = n_1
            n_1 = s
            
        return n_1