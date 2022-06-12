object Solution {
    def numIslands(grid: Array[Array[Char]]): Int = {
        var res = 0
        
        for(r <- 0 to grid.length - 1) {
            for(c <- 0 to grid(0).length - 1) {
                if (grid(r)(c) != '0') {
                    helper(r, c, grid)
                    res += 1
                }
            }
        }
        
        res
    }
    
    def helper(r: Int, c: Int, grid: Array[Array[Char]]): Unit = {
        grid(r)(c) = '0'
        
        for(n <- Seq((1, 0), (-1, 0), (0, 1), (0, -1))) {
            val nr = r + n._1
            val nc = c + n._2
            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid(0).length && grid(nr)(nc) != '0') {
                helper(nr, nc, grid)
            }
        }
    }
}