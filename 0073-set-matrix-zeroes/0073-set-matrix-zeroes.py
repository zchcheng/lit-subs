class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        
        first_row = True
        first_col = True
        
        for i in range(len(matrix)):
            for j in range(len(matrix[i])):
                if matrix[i][j] != 0: continue
                if i != 0: matrix[i][0] = 0
                if j != 0: matrix[0][j] = 0
                if i == 0: first_row = False
                if j == 0: first_col = False
                    
        for i in range(1, len(matrix)):
            for j in range(1, len(matrix[i])):
                if matrix[i][0] == 0 or matrix[0][j] == 0:
                    matrix[i][j] = 0
                    
        if not first_row:
            for i in range(len(matrix[0])):
                matrix[0][i] = 0
                
        if not first_col:
            for i in range(len(matrix)):
                matrix[i][0] = 0
                
        