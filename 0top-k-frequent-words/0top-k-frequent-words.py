class Solution:
    def topKFrequent(self, words: List[str], k: int) -> List[str]:
        pq = []
        
        cnt = collections.Counter(words)
        
        for w, f in cnt.items():
            heapq.heappush(pq, Frequency(w, f))
            
            if len(pq) > k:
                heapq.heappop(pq)
                
        res = []
        while len(pq) > 0:
            res.insert(0, heapq.heappop(pq).word)
            
        return res
        
class Frequency:
    def __init__(self, w: str, f: int):
        self.word = w
        self.freq = f
        
    def __lt__(self, other):
        if self.freq != other.freq:
            return self.freq < other.freq
        else:
            return other.word < self.word