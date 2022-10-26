class Solution:
    def trap(self, height: List[int]) -> int:
        stack = []
        
        res = 0
        for i, h in enumerate(height):
            while len(stack) > 0 and stack[-1][0] <= h:
                tmp = stack.pop()
                p = (0, -1) if len(stack) == 0 else stack[-1]
                res += max(0, (min(h, p[0]) - tmp[0]) * (i - p[1] - 1))
            stack.append((h, i))
            
        return res
        
            