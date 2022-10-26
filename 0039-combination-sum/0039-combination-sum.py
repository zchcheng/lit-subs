class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []
        self.helper(0, candidates, [], res, 0, target)
        return res
        
    def helper(self, i: int, cand: List[int], cur: List[int], res: List[List[int]], curSum: int, target: int) -> None:
        if curSum >= target or i >= len(cand):
            if curSum == target:
                res.append(cur[:])
            return
            
        cur.append(cand[i])
        self.helper(i, cand, cur, res, curSum + cand[i], target)
        cur.pop()
        
        self.helper(i + 1, cand, cur, res, curSum, target)
        
