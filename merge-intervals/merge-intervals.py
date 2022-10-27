class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda x: x[0])
        
        res = []
        
        cur = None
        for intv in intervals:
            if not cur:
                cur = intv
            if cur[1] < intv[0]:
                res.append(cur)
                cur = intv
            cur[1] = max(cur[1], intv[1])
            
        res.append(cur)
        
        return res
    
