class Solution:
    def __init__(self):
        self.numOfIsland = 0
    
    def numIslands(self, grid: List[List[str]]) -> int:
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.helper(grid, [i, j])
                    
        return self.numOfIsland
        
        
    def helper(self, grid: List[List[str]], loc: List[int]) -> None:
        self.numOfIsland += 1
        
        q = deque()
        
        if grid[loc[0]][loc[1]] == '1':
            q.append(loc)
            grid[loc[0]][loc[1]] = '0'
            
        while len(q) > 0:
            l = q.popleft()
            if grid[l[0]][l[1]] != '0': continue
            
            for m in [[0, 1], [0, -1], [1, 0], [-1, 0]]:
                nx = l[0] + m[0]
                ny = l[1] + m[1]
                
                if nx < 0 or ny < 0 or nx >= len(grid) or ny >= len(grid[nx]) or grid[nx][ny] != '1':
                    continue
                    
                q.append([nx, ny])
                grid[nx][ny] = '0'
        
                
        
        