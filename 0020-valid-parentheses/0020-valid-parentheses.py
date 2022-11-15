class Solution:
    def isValid(self, s: str) -> bool:
        pair = {')': '(', '}': '{', ']': '['}
        stack = []
        
        for c in s:
            if c in pair:
                if not stack or stack[-1] != pair[c]:
                    return False
                stack.pop()
            else:
                stack.append(c)
                
        return True if not stack else False