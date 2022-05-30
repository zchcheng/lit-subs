object Solution {
    def maxProfit(prices: Array[Int]): Int = {
        var res = 0
        var m = Integer.MAX_VALUE
        
        prices.foreach { x =>
            res = (x - m) max res
            m = m min x
        }
        
        res
    }
}