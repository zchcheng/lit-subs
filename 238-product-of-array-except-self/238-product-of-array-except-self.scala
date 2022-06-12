object Solution {
    def productExceptSelf(nums: Array[Int]): Array[Int] = {
        val res = Array.fill(nums.length)(0)
        
        var cur = 1
        for(i <- 0 to nums.length - 1) {
            res(i) = cur
            cur *= nums(i)
        }
        
        cur = 1
        for(i <- (0 to nums.length - 1).reverse) {
            res(i) *= cur
            cur *= nums(i)
        }
        
        res
    }
}