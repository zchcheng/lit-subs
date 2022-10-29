class Solution:
    memo = None
    s1 = None
    s2 = None
    
    def minDistance(self, word1: str, word2: str) -> int:
        lw1 = len(word1)
        lw2 = len(word2)
        self.s1 = word1
        self.s2 = word2
        self.memo = [ [-1 for _ in range(lw2 + 1) ] for _ in range(lw1 + 1) ]
        return self.helper(0, 0)
        
    def helper(self, i1, i2):
        if self.memo[i1][i2] != -1:
            return self.memo[i1][i2]
        
        if i1 >= len(self.s1) and i2 >= len(self.s2):
            self.memo[i1][i2] = 0
        elif i1 >= len(self.s1):
            self.memo[i1][i2] = len(self.s2) - i2
        elif i2 >= len(self.s2):
            self.memo[i1][i2] = len(self.s1) - i1
        elif self.s1[i1] == self.s2[i2]:
            self.memo[i1][i2] = self.helper(i1 + 1, i2 + 1)
        else: self.memo[i1][i2] = min(self.helper(i1 + 1, i2), self.helper(i1, i2 + 1)) + 1
            
        return self.memo[i1][i2]
