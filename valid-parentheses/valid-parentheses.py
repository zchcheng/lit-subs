class Solution:
    def isValid(self, s: str) -> bool:
        m = {
            '}': '{',
            ']': '[',
            ')': '('
        }
        
        stack = []
        
        for c in s:
            if c in m:
                if len(stack) == 0 or stack.pop() != m.get(c):
                    return False
                continue
            stack.append(c)
            
        return len(stack) == 0
        
        