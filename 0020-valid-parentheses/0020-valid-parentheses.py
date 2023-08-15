class Solution:
    def isValid(self, s: str) -> bool:
        pairs = { '}': '{', ']': '[', ')': '(' }

        stack = []
        for c in s:
            if c not in pairs:
                stack.append(c)
                continue
            if len(stack) == 0 or stack[-1] != pairs[c]:
                return False
            stack.pop()

        return len(stack) == 0
            