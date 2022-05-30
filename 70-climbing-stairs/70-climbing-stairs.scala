object Solution {
    def climbStairs(n: Int): Int = {
        val arr: Array[Int] = Array.fill(n + 1) {0}
        arr(0) = 1
        arr(1) = 1
        
        for(i <- 2 to n) {
            arr(i) = arr(i - 1) + arr(i - 2)
        }
        
        arr(n)
    }
}