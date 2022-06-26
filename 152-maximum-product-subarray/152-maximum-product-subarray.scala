object Solution {
    def maxProduct(nums: Array[Int]): Int = {
        var max = nums(0)
        var min = nums(0)
        var res = max

        for(i <- 1 to nums.length - 1) {
            val num = nums(i)
            var nmax = 0
            var nmin = 0
            
            if (num == 0) {
                nmax = 0
                nmin = 0
            } else if (num > 0) {
                nmax = num max (num * max)
                nmin = num min (num * min)
            } else {
                nmax = num max (num * min)
                nmin = num min (num * max)
            }
            
            max = nmax
            min = nmin
            res = res max max
        }

        res
    }
}