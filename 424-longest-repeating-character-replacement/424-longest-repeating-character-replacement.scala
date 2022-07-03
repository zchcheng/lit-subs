import scala.collection.mutable._

object Solution {
    def characterReplacement(s: String, k: Int): Int = {
        var start = 0
        var end = 0
        val map: Map[Char, Int] = Map()
        var res = 0
        var maxCnt = 0

        for(end <- 0 to s.length - 1) {
            val c = s.charAt(end)
            val cnt = map.get(c).getOrElse(0) + 1
            map += (c -> cnt)

            maxCnt = maxCnt max cnt

            while(end - start + 1 - maxCnt > k) {
                val r = s.charAt(start)
                map += (r -> (map.get(r).get - 1))
                start += 1
            }

            res = res max (end - start + 1)
        }

        res
    }
}