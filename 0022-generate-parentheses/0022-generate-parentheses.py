class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return ['']
        
        res = []
        for i in range(n):
            for p1 in self.generateParenthesis(i):
                for p2 in self.generateParenthesis(n - i - 1):
                    res.append('(' + p1 + ')' + p2)
            
        return res
            
        