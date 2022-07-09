object Solution {
    def trap(height: Array[Int]): Int = {
        var left = 0
        var right = height.length - 1
        var res = 0

        var lm = 0
        var rm = 0

        while (left < right) {
            lm = height(left) max lm
            rm = height(right) max rm

            if (lm <= rm) {
                res += lm - height(left)
                left += 1
            } else {
                res += rm - height(right)
                right -= 1
            }
        }

        res
    }
}