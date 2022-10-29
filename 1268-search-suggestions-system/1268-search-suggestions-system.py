class Trie:
    def __init__(self):
        self.next = [None] * 26
        self.word = None
        
class Solution:
    root = None
    
    def suggestedProducts(self, products: List[str], searchWord: str) -> List[List[str]]:
        self.root = Trie()
        res = []
        
        self.buildTrie(products)
        
        current = self.root
        for c in searchWord:
            r = []
            
            if not current or not current.next[self.idx(c)]:
                current = None
                res.append(r)
                continue
            
            current = current.next[self.idx(c)]
            self.find(current, r)
            
            res.append(r)
            
        return res
        
        
    def find(self, n, res):
        if not n:
            return
        
        if len(res) >= 3:
            return
        
        if n.word:
            res.append(n.word)
            
        for i in range(26):
            if n.next[i]:
                self.find(n.next[i], res)
                if len(res) >= 3:
                    return
        
    
    def buildTrie(self, products):
        for prod in products:
            current = self.root
            for c in prod:
                if not current.next[self.idx(c)]:
                    current.next[self.idx(c)] = Trie()
                current = current.next[self.idx(c)]
            current.word = prod
            
                
    def idx(self, c):
        return ord(c) - ord('a')
        
