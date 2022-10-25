class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        for i in range(9):
            if (not self.checkCol(board, i) or not self.checkRow(board, i)):
                return False
            
        for i in range(3):
            r = i * 3
            for j in range(3):
                c = j * 3
                if not self.checkBox(board, [r, c], [r + 2, c + 2]):
                    return False
                
        return True
        
        
    def checkCol(self, board, col):
        seen = [False] * 10
        for i in range(9):
            if board[i][col] == '.':
                continue
            if seen[int(board[i][col])]:
                return False
            seen[int(board[i][col])] = True
        return True
            
    def checkRow(self, board, row):
        seen = [False] * 10
        for i in range(9):
            if board[row][i] == '.':
                continue
            if seen[int(board[row][i])]:
                return False
            seen[int(board[row][i])] = True
        return True
        
        
    def checkBox(self, board, ul, br):
        seen = [False] * 10
        for r in range(ul[0], br[0] + 1):
            for c in range(ul[1], br[1] + 1):
                if board[r][c] == '.':
                    continue
                if seen[int(board[r][c])]:
                    return False
                seen[int(board[r][c])] = True
        return True