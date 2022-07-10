object Solution {
    def calculate(s: String): Int = {
        var res = 0
        var cur = 0
        var neg = false

        def addup(v: Int, isNeg: Boolean): Unit = {
            if (isNeg) res -= v
            else res += v
        }

        var i = 0
        while(i < s.length) {
            s.charAt(i) match {
                case '(' => 
                    val e = getPair(s, i)
                    val v = calculate(s.subSequence(i + 1, e).toString)
                    addup(v, neg)
                    i = e
                case '+' => 
                    addup(cur, neg)
                    neg = false
                    cur = 0
                case '-' => 
                    addup(cur, neg)
                    neg = true
                    cur = 0
                case c if c.isDigit => 
                    val d = c.getNumericValue
                    cur = cur * 10 + d
                case _ => 
            }

            i += 1
        }
                       
        addup(cur, neg)

        res
    }

    def getPair(s: String, idx: Int): Int = {
        if (s.charAt(idx) != '(') return idx
        else {
            var i = idx + 1
            var stack = 1

            while (i < s.length && stack > 0) {
                if (s.charAt(i) == ')') stack -= 1
                else if (s.charAt(i) == '(') stack += 1
                if (stack != 0) i += 1
            }

            i
        }
    }
}