object Solution {
    def countBits(n: Int): Array[Int] = {
        val res: Array[Int] = Array.fill(n + 1) {0}
        var pow2 = 1
        var j = 0
        
        for(i <- 1 to n) {
            if (i == pow2) {
                pow2 *= 2
                j = 0
            }
            
            res(i) = res(j) + 1
            j += 1
        }
        
        res
    }
}