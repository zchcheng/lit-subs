import scala.collection.mutable._

object Solution {
    def threeSum(nums: Array[Int]): List[List[Int]] = {
        var res: List[List[Int]] = List()
        
        val sorted = nums.sorted(Ordering.Int)
        
        for(i <- 0 to sorted.length - 3) {
            if (i == 0 || sorted(i) != sorted(i - 1)) {
                val pivot = sorted(i)
                var s = i + 1
                var e = sorted.length - 1

                while(s < e) {
                    val sum = sorted(s) + sorted(e) + pivot

                    if (sum == 0) {
                        res = res :+ List(sorted(s), sorted(e), pivot)
                        var ns = s + 1
                        var ne = e - 1
                        while(ns < sorted.length && sorted(ns) == sorted(s)) ns += 1
                        while(ne >= 0 && sorted(ne) == sorted(e)) ne -= 1
                        s = ns
                        e = ne
                    } else if (sum < 0) {
                        s += 1
                    } else {
                        e -= 1
                    }
                }
            }
        }
        
        res
    }
}