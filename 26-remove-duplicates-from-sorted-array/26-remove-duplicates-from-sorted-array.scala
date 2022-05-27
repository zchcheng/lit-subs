object Solution {
    def removeDuplicates(nums: Array[Int]): Int = {
        var j = -1
        
        for(i <- 0 to nums.length - 1) {
            if (j == -1 || nums(j) != nums(i)) {
                j += 1
                nums(j) = nums(i)
            }
        }
        
        j+1
    }
}