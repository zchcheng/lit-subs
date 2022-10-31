class Solution:
    removed = None
    result = set()
    
    def removeInvalidParentheses(self, s: str) -> List[str]:
        self.removed = len(s)
        self.backtracking(s, 0, '', 0, 0)
        return [ x for x in self.result ]
        
    def backtracking(self, s: str, st: int, cur: str, index: int, curRemoved: int):
        if index >= len(s):
            if st == 0:
                if curRemoved < self.removed:
                    self.removed = curRemoved
                    self.result = set()
                if curRemoved <= self.removed:
                    self.result.add(cur)
            return

        c = s[index]
        
        if c.isalpha():
            self.backtracking(s, st, cur + c, index + 1, curRemoved)
            return
        
        self.backtracking(s, st, cur, index + 1, curRemoved + 1)
        
        if c == ')' and st == 0:
            return
        
        newCur = cur + c

        st += 1 if c == '(' else -1 
        
        self.backtracking(s, st, newCur, index + 1, curRemoved)
                
        
        