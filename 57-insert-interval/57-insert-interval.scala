object Solution {
    def insert(
        intervals: Array[Array[Int]],
        newInterval: Array[Int]
    ): Array[Array[Int]] = {
        val lower = findLower(intervals, newInterval)
        val higher = findHigher(intervals, newInterval)
        var res: Array[Array[Int]] = Array()

        res = res ++: intervals.slice(0, lower + 1)

        for (i <- lower + 1 to higher - 1) {
            val intv = intervals(i)
            newInterval(0) = Math.min(intv(0), newInterval(0))
            newInterval(1) = Math.max(intv(1), newInterval(1))
        }
        
        res = res :+ newInterval
        res = res ++: intervals.slice(higher, intervals.length)

        res
    }

    def findLower(intvs: Array[Array[Int]], nIntv: Array[Int]): Int = {
        var start = 0
        var end = intvs.length - 1

        while (start <= end) {
            val mid = (start + end) / 2
            val intv = intvs(mid)
            if (intv(1) < nIntv(0)) start = mid + 1
            else end = mid - 1
        }

        end
    }

    def findHigher(intvs: Array[Array[Int]], nIntv: Array[Int]): Int = {
        var start = 0
        var end = intvs.length - 1

        while (start <= end) {
            val mid = (start + end) / 2
            val intv = intvs(mid)
            if (intv(0) <= nIntv(1)) start = mid + 1
            else end = mid - 1
        }

        start
    }
}