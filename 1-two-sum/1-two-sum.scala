object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var map: Map[Int, Int] = Map()
        var res: Array[Int] = null
        val len = nums.length
        
        for(i <- 0 to len - 1) {
            val dif = target - nums(i)
            if (map.contains(dif)) {
                res = Array(map(dif), i)
            }
            map += (nums(i) -> i)
        }
        
        res
    }
}