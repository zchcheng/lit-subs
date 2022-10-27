class Solution:
    text = ''
    pat = ''
    
    def isMatch(self, s: str, p: str) -> bool:
        self.pat = p
        self.text = s
        return self.helper(0, 0)
        
    @cache
    def helper(self, i, j) -> bool:
        
        if j >= len(self.pat):
            return i >= len(self.text)
        
        match = i < len(self.text) and self.pat[j] in { self.text[i], '.' }
        
        if j + 1 < len(self.pat) and self.pat[j + 1] == '*':
            return self.helper(i, j + 2) or (match and self.helper(i + 1, j))
        else:
            return match and self.helper(i + 1, j + 1)
            
        
