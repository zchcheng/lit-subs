class Solution:
    def interchangeableRectangles(self, rectangles: List[List[int]]) -> int:
        ratios = defaultdict(lambda: 0)
        
        for rect in rectangles:
            ratio = rect[0] / rect[1]
            ratios[ratio] += 1
            
        res = 0
        
        for k, v in ratios.items():
            res += v * (v - 1) // 2
            
        return res
            