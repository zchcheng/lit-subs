class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        self.helper(n, 0, '', res)
        return res
        
        
    def helper(self, sl: int, cl: int, cur: str, res: List[str]) -> None:
        if sl == 0 and cl == 0:
            res.append(cur)
            return
        
        if sl > 0:
            self.helper(sl - 1, cl + 1, cur + '(', res)
            
        if cl > 0:
            self.helper(sl, cl - 1, cur + ')', res)
        