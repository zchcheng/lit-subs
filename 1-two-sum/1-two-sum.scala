object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        var map: Map[Int, Int] = Map()
        nums.zipWithIndex.map {
            case (n, idx) if map.contains(target - n) => 
                Some(Array[Int](idx, map.get(target - n).get))
            case (n, idx) => {
                map += (n->idx)
                None
            }
        }.flatten.head
    }
}