object Solution {
    def canCompleteCircuit(gas: Array[Int], cost: Array[Int]): Int = {
        var total = 0
        var cur = 0
        val n = gas.length
        var start = 0

        for(i <- 0 to n - 1) {
            val gain = gas(i) - cost(i)
            total += gain
            cur += gain
            if (cur < 0) { 
                start = (i + 1) % n
                cur = 0
            }
        }

        if (total < 0) -1 else start
    }
}