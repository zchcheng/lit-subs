object Solution {
    def canJump(nums: Array[Int]): Boolean = {
        val l = nums.length - 1
        var f = l

        for(i <- 1 to nums.length - 1) {
            if (l - i + nums(l - i) >= f) {
                f = l - i
            }
        }

        f == 0
    }
}