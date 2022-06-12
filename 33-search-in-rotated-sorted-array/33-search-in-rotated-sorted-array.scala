object Solution {
    def search(nums: Array[Int], target: Int): Int = {
        var s = 0
        var e = nums.length - 1
        var res = -1
        
        while(res == -1 && s <= e) {
            val mid = (s + e) / 2
            val v = nums(mid)
            val vs = nums(s)
            val ve = nums(e)
            
            if (v == target) {
                res = mid 
            } else if (
                (vs < v && target >= vs && target <= v) ||
                (vs > v && (target >= vs || target <= v))
            ) { // the possible answer is on the left
                e = mid - 1
            } else { // the possible answer is on the right
                s = mid + 1
            }
        }
        
        res
    }
}