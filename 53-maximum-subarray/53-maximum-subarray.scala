object Solution {
    def maxSubArray(nums: Array[Int]): Int = {
        var res = nums.reduce(_ max _)
        var cur = 0
        
        if (res >= 0) {
            for(n <- nums) {
                cur += n
                cur = cur max 0
                res = res max cur
            }
        }
        
        res
    }
}