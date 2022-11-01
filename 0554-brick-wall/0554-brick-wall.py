class Solution:
    def leastBricks(self, wall: List[List[int]]) -> int:
        edges = defaultdict(lambda: 0)
        
        for w in wall:
            s = 0
            for i in range(len(w) - 1):
                lb = w[i]
                s += lb
                edges[s] += 1
                
        res = len(wall)
        
        for k, v in edges.items():
            res = min(res, len(wall) - v)
            
        return res