class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        return self.helper(word1, word2)
        

    @cache
    def helper(self, s1, s2):
        if not s1 and not s2:
            return 0
        
        if not s1:
            return len(s2)
        if not s2:
            return len(s1)
        
        if s1[0] == s2[0]:
            return self.helper(s1[1:], s2[1:])
        
        return 1 + min(self.helper(s1[1:], s2), self.helper(s1, s2[1:]))