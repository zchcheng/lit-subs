object Solution {
    def nextPermutation(nums: Array[Int]): Unit = {
        var i: Int = nums.length - 1
        var found = false

        while(i > 0 && !found) {
            if (nums(i) > nums(i - 1)) found = true
            else i -= 1
        }

        i -= 1
        
        if (i == -1) {
            reverse(nums, 0, nums.length - 1)
        } else {
            var k = i + 1
            var j = i + 1

            while(k < nums.length) {
                if (nums(k) > nums(i)) j = k
                k += 1
            }

            swap(nums, i, j)
            reverse(nums, i + 1, nums.length - 1)
        }
    }

    def swap(nums: Array[Int], a: Int, b: Int): Unit = {
        val tmp = nums(a)
        nums(a) = nums(b)
        nums(b) = tmp
    }

    def reverse(nums: Array[Int], start: Int, end: Int): Unit = {
        var i = start
        var j = end
        while(i < j) {
            swap(nums, i, j)
            i += 1
            j -= 1
        }
    }
}