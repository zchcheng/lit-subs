class Solution:
    sat = None
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        # helper(1, [-8, -1, 0, 5])
        #  max(-1 * -8 + maxSatisfaction(2, [-1, 0, 5]), maxSatisfaction(1, [-1, 0, 5]))
        
        satisfaction.sort()
        self.sat = satisfaction
        return self.helper(1, 0)
        
    @cache
    def helper(self, si, i):
        if i >= len(self.sat):
            return 0
        return max(si * self.sat[i] + self.helper(si + 1, i + 1), self.helper(si, i + 1))
        