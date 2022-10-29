class Solution:
    s1 = None
    s2 = None
    
    def minDistance(self, word1: str, word2: str) -> int:
        lw1 = len(word1)
        lw2 = len(word2)
        self.s1 = word1
        self.s2 = word2
        return self.helper(0, 0)
        
    @cache
    def helper(self, i1, i2):
        if i1 >= len(self.s1) and i2 >= len(self.s2):
            return 0
        
        if i1 >= len(self.s1):
            return len(self.s2) - i2
        
        if i2 >= len(self.s2):
            return len(self.s1) - i1
        
        if self.s1[i1] == self.s2[i2]:
            return self.helper(i1 + 1, i2 + 1)
        return min(self.helper(i1 + 1, i2), self.helper(i1, i2 + 1)) + 1
