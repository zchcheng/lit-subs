class Solution:
    st = ''
    wd = []
    
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.st = s
        self.wd = wordDict
        return self.helper(0)
        
        
    @lru_cache    
    def helper(self, i) -> bool:
        if i >= len(self.st):
            return True
        for w in self.wd:
            if self.st[i:i+len(w)] == w and self.helper(i + len(w)):
                return True
        return False
        