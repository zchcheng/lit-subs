class Solution:
    def pushDominoes(self, d: str) -> str:
        n = len(d)
        forces = [0] * n
        
        cf = 0
        for i in range(n):
            if d[i] == 'R':
                cf = n
            elif d[i] == 'L':
                cf = 0
            else:
                cf = max(0, cf - 1)
            forces[i] += cf
            
        cf = 0
        for i in range(n - 1, -1, -1):
            if d[i] == 'L':
                cf = -n
            elif d[i] == 'R':
                cf = 0
            else:
                cf = min(0, cf + 1)
            forces[i] += cf
            
        res = ''
        
        for i in range(n):
            if forces[i] > 0:
                res += 'R'
            elif forces[i] < 0:
                res += 'L'
            else:
                res += '.'
                
        return res
                
