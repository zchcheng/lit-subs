class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        m = {}
        
        for s in strs:
            enc = self.encode(s)
            if enc in m:
                m.get(enc).append(s)
            else:
                m[enc] = [s]
                
        return list(m.values())    
        
    def encode(self, s: str) -> str:
        bkt = [0] * 26
        b = ord('a')
        for c in s: bkt[ord(c) - b] += 1
        return str(bkt)
        