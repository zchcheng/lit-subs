class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        
        w2Bucket = [0] * 26
        
        for w in words2:
            bucket = self.getCharSet(w)
            for i in range(26):
                w2Bucket[i] = max(w2Bucket[i], bucket[i])
                
        res = []
        
        for w in words1:
            if self.isUniversal(w, w2Bucket):
                res.append(w)
                
        return res
    
    def isUniversal(self, word, need):
        bucket = self.getCharSet(word)
        
        for i in range(26):
            if need[i] > bucket[i]:
                return False
            
        return True
        
    
    def getCharSet(self, word):
        bucket = [0] * 26
        
        for c in word:
            bucket[ord(c) - ord('a')] += 1
            
        return bucket
            
    