object Solution {
    def searchInsert(nums: Array[Int], target: Int): Int = {
        var s = 0
        var e = nums.length - 1
        var found = false
        
        while(s <= e && !found) {
            val m = (s + e) / 2
            
            if (nums(m) == target) {
                s = m
                found = true
            } else if (nums(m) < target) {
                s = m + 1
            } else {
                e = m - 1
            }
        }
        
        s
    }
}