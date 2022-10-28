class Solution:
    def numDecodings(self, s: str) -> int:
        return self.helper(s)
        
    @cache
    def helper(self, s):
        if not s:
            return 1
        
        if s[0] == '0':
            return 0
        
        sum = self.helper(s[1:])

        if len(s) > 1 and (s[0] == '1' or (s[0] == '2' and ord(s[1]) - ord('0') <= 6)):
            sum += self.helper(s[2:])
            
        return sum
        
        
        