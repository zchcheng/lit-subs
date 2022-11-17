class Solution:
    def computeArea(self, ax1: int, ay1: int, ax2: int, ay2: int, bx1: int, by1: int, bx2: int, by2: int) -> int:
        aa = self.area(ax1, ay1, ax2, ay2)
        ab = self.area(bx1, by1, bx2, by2)
        overlapping = max(0, self.area(max(ax1, bx1), max(ay1, by1), min(ax2, bx2), min(ay2, by2)))
                          
        return aa + ab - overlapping
        
        
    def area(self, x1, y1, x2, y2):
        return 0 if (x2 <= x1 or y2 <= y1) else (x2 - x1) * (y2 - y1)