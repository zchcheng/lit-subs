class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[i])):
                if self.helper(board, word, [i, j], 0):
                    return True
        return False
        
        
    def helper(self, board: List[List[str]], word: str, loc: List[int], i: int) -> bool:
        if i >= len(word):
            return True
        
        if loc[0] < 0 or loc[1] < 0 or loc[0] >= len(board) or loc[1] >= len(board[loc[0]]) or board[loc[0]][loc[1]] != word[i]:
            return False
        
        tmp = board[loc[0]][loc[1]]
        board[loc[0]][loc[1]] = ' '
        
        for x, y in [1, 0], [-1, 0], [0, 1], [0, -1]:
            lx = loc[0] + x
            ly = loc[1] + y
            
            if self.helper(board, word, [lx, ly], i + 1):
                return True
            
        board[loc[0]][loc[1]] = tmp
        return False