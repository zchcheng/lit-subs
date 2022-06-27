object Solution {
    def rotate(nums: Array[Int], k: Int): Unit = {
        val r = k % nums.length
        reverse(nums, 0, nums.length - 1)
        reverse(nums, 0, r - 1)
        reverse(nums, r, nums.length - 1)
    }

    def reverse(nums: Array[Int], start: Int, end: Int): Unit = {
        var s = start
        var e = end
        while(s < e) {
            swap(nums, s, e)
            s += 1
            e -= 1
        }
    }

    def swap(nums: Array[Int], a: Int, b: Int): Unit = {
        val tmp = nums(a)
        nums(a) = nums(b)
        nums(b) = tmp
    }
}