class Solution:
    def maxSatisfaction(self, sat: List[int]) -> int:
        sat.sort()
        
        s = 0
        res = 0
        
        for i in range(len(sat) - 1, -1, -1):
            if sat[i] < 0 and abs(sat[i]) > s:
                break
            s += sat[i]
            res += s
            
        return res