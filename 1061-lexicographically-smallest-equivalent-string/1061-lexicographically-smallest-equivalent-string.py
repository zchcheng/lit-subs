class Solution:
    parent = {}
    
    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        self.parent = {}
        
        n = len(s1)
        
        for c1, c2 in zip(s1, s2):
            self.union(c1, c2)
            
        return ''.join([ self.find(x) for x in baseStr ])
        
    
    def find(self, a):
        if a not in self.parent:
            self.parent[a] = a
            return a
        
        if self.parent[a] != a:
            self.parent[a] = self.find(self.parent[a])
        return self.parent[a]
    
    def union(self, a, b):
        pa = self.find(a)
        pb = self.find(b)
        
        if pa < pb:
            self.parent[pb] = pa
        else:
            self.parent[pa] = pb
            
        
        