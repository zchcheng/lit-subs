class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return ['']
        
        res = []
        for i in range(n):
            p_i = self.generateParenthesis(i)
            p_l = self.generateParenthesis(n - i - 1)
            
            for p1 in p_i:
                for p2 in p_l:
                    res.append('(' + p1 + ')' + p2)
            
        return res
            
        