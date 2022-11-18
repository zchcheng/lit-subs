class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        intervals.sort()
        
        s_idx = self.bin_search(intervals, lambda i: True if i[1] >= newInterval[0] else False, lambda l, r: r)
        e_idx = self.bin_search(intervals, lambda i: True if i[0] > newInterval[1] else False, lambda l, r: l)
        
        res = intervals[:s_idx + 1]
        
        if s_idx + 1 > e_idx - 1:
            res.append(newInterval)
            return res + intervals[e_idx:] if len(res) < len(intervals) + 1 else res
            
        res.append([min(newInterval[0], intervals[s_idx + 1][0]), max(newInterval[1], intervals[e_idx - 1][1])])
        return res + intervals[e_idx:]
        
        
        
    def bin_search(self, intervals, rl_func, rs_func):
        l, r = 0, len(intervals) - 1
        
        while l <= r:
            m = (l + r) // 2
            interval = intervals[m]
            if rl_func(interval): 
                r = m - 1
            else: 
                l = m + 1
                
        return rs_func(l, r)
        