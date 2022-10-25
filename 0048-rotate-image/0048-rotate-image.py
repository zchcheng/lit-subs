class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        self.trans(matrix)
        self.mirror(matrix)
        
        
    def mirror(self, mat):
        r = len(mat)
        c = len(mat[0])
        
        for i in range(r / 2):
            for j in range(c):
                mat[i][j], mat[r - i - 1][j] = mat[r - i - 1][j], mat[i][j]
        
        
    def trans(self, mat):
        r = len(mat)
        c = len(mat[0])
        
        for i in range(r):
            for j in range(r - i):
                mat[i][j], mat[r - j - 1][c - i - 1] = mat[r - j - 1][c - i - 1], mat[i][j]
        
        