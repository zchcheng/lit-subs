class Solution:
    tcs = None
    used = None
    target = None
    
    def closestCost(self, baseCosts: List[int], toppingCosts: List[int], target: int) -> int:
        self.tcs = toppingCosts
        self.used = [0] * len(toppingCosts)
        
        res = None
        
        for c in baseCosts:
            self.target = target - c
            cost = self.backtracking(0, 0)
            
            tmp = cost + c
            
            if res is None:
                res = tmp
                continue
            
            d1 = abs(tmp - target)
            d2 = abs(res - target)
            
            if d1 < d2:
                res = tmp
            elif d2 < d1:
                continue
            else:
                res = min(tmp, res)

        return res
            
            
    def backtracking(self, i, current):
        if i >= len(self.tcs):
            return current
        
        c1 = current
        
        if self.used[i] < 2:
            self.used[i] += 1
            c1 = self.backtracking(i, current + self.tcs[i])
            self.used[i] -= 1
            
        c2 = self.backtracking(i + 1, current)
        
        d1 = abs(c1 - self.target)
        d2 = abs(c2 - self.target)
        
        if d1 == d2:
            return min(c1, c2)
        if d1 < d2:
            return c1
        return c2
        