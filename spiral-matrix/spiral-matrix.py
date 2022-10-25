class Solution:
    def spiralOrder(self, m: List[List[int]]) -> List[int]:
        r = len(m)
        c = len(m[0])
        
        bdy_v = [-1, r]
        bdy_h = [-1, c]
        
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        cd = 0
        
        res = []
        cl = [0, 0]
        
        for i in range(r * c):
            res.append(m[cl[0]][cl[1]])
            
            nr = cl[0] + dirs[cd][0]
            nc = cl[1] + dirs[cd][1]
            
            if nr == bdy_v[0] or nr == bdy_v[1] or nc == bdy_h[0] or nc == bdy_h[1]:
                cd = (cd + 1) % len(dirs)
                bdy_v[0] = max(bdy_v[0], bdy_v[0] + dirs[cd][0])
                bdy_v[1] = min(bdy_v[1], bdy_v[1] + dirs[cd][0])
                bdy_h[0] = max(bdy_h[0], bdy_h[0] + dirs[cd][1])
                bdy_h[1] = min(bdy_h[1], bdy_h[1] + dirs[cd][1])
                
            cl[0] += dirs[cd][0]
            cl[1] += dirs[cd][1]
            
        return res
                
                
            