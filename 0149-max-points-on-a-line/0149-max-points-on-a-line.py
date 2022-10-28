class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        res = 1
        
        for x1, y1 in points:
            
            slope = defaultdict(lambda: 1)
            nh = 1
            
            for x2, y2 in points:
                k = 0
                if x1 == x2 and y1 == y2:
                    continue
                if x1 != x2:
                    ns = (y1 - y2) / (x1 - x2)
                    slope[ns] += 1
                    k = slope[ns]
                else:
                    nh += 1
                    k = nh
                
                res = max(k, res)
                
        return res
                