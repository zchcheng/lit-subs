object Solution {
    def findDuplicate(nums: Array[Int]): Int = {
        var fast = nums(0)
        var slow = nums(0)

        var firstStep = true

        while(firstStep || fast != slow) {
            firstStep = false
            fast = nums(nums(fast))
            slow = nums(slow)
        }

        fast = nums(0)

        while(fast != slow) {
            slow = nums(slow)
            fast = nums(fast)
        }

        fast 
    }
}