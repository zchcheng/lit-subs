class HitCounter:

    def __init__(self):
        self.q = []
        

    def hit(self, timestamp: int) -> None:
        self.q.append(timestamp)
        self.rotate(timestamp - 300)
        

    def getHits(self, timestamp: int) -> int:
        self.rotate(timestamp - 300)
        return len(self.q)
        
        
    def rotate(self, timestamp: int) -> None:
        while self.q and self.q[0] <= timestamp:
            self.q.pop(0)
        


# Your HitCounter object will be instantiated and called as such:
# obj = HitCounter()
# obj.hit(timestamp)
# param_2 = obj.getHits(timestamp)