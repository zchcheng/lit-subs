class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        return self.encode(s) == self.encode(t)
        
        
    def encode(self, s: str) -> str:
        b = [0] * 26
        for c in s:
            b[ord(c) - ord('a')] += 1
        r = ''
        for i in b:
            r += str(b) + ' '
        return r