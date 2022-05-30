object Solution {
    def majorityElement(nums: Array[Int]): Int = {
        var cur: Int = 0
        var cnt: Int = 0
        
        nums.foreach { n => 
            if (cnt == 0) {
                cur = n
                cnt = 1
            } else {
                cnt = if (cur == n) cnt + 1 else cnt - 1
            }
        }
        
        cur
    }
}