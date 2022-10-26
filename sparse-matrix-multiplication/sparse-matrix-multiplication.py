class Solution:
    def multiply(self, mat1: List[List[int]], mat2: List[List[int]]) -> List[List[int]]:
        if len(mat1) == 0 or len(mat2) == 0: return []
        
        tr = len(mat1)
        tc = len(mat2[0])
        
        m1_r = {}
        m2_c = {}
        
        for r, row in enumerate(mat1):
            for c, el in enumerate(row):
                if el:
                    m1_r[r] = {**m1_r.get(r, {}), c: el}
                
        for r, row in enumerate(mat2):
            for c, el in enumerate(row):
                if el:
                    m2_c[c] = {**m2_c.get(c, {}), r: el}
                
        res = [[0 for _ in range(tc)] for _ in range(tr)]
        
        for r1, row in m1_r.items():
            for c1, el1 in row.items():
                for c2, col in m2_c.items():
                    res[r1][c2] += col.get(c1, 0) * el1
                    
                
                
        return res
                