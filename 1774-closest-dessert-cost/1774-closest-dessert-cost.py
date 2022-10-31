class Solution:
    best = None
    
    def closestCost(self, baseCosts: List[int], toppingCosts: List[int], target: int) -> int:
        self.best = target - baseCosts[0]
        for bc in baseCosts:
            self.backtracking(toppingCosts, 0, target - bc)
        return target - self.best
            
        
    def backtracking(self, tcs, idx, cur):
        if abs(cur) < abs(self.best) or (abs(cur) == abs(self.best) and cur > self.best):
            self.best = cur
            
        if idx >= len(tcs) or cur <= 0:
            return cur
        
        self.backtracking(tcs, idx + 1, cur)
        self.backtracking(tcs, idx + 1, cur - tcs[idx])
        self.backtracking(tcs, idx + 1, cur - 2 * tcs[idx])
