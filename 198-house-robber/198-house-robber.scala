object Solution {
    def rob(nums: Array[Int]): Int = {
        var a = 0
        var b = 0

        for(i <- 0 to nums.length - 1) {
            val n = nums(i)
            val c = (a + n) max b
            a = b
            b = c
        }

        a max b
    }
}