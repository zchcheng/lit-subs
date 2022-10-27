class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        pq = []
        
        for p in points:
            heapq.heappush(pq, Point(p[0], p[1]))
            if len(pq) > k:
                heapq.heappop(pq)
                
        return [ [p.x, p.y] for p in pq ]
        
        
class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        
    def __lt__(self, other):
        return other.x ** 2 + other.y ** 2 < self.x ** 2 + self.y ** 2