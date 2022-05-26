object Solution {
    def romanToInt(s: String): Int = {
        val map: Map[Char, Int] = Map('I'->1, 'V'->5, 'X'->10, 'L'->50, 'C'->100, 'D'->500, 'M'->1000)
        val vals = s.map(map)
        vals.zipWithIndex.map{ case (e, i) => 
            if (i < vals.length - 1 && (vals(i + 1) == 5 * e || vals(i + 1) == 10 * e)) -e else e
        }.reduce(_ + _)
    }
}