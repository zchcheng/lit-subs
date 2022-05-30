object Solution {
    def backspaceCompare(s: String, t: String): Boolean = {
        var i = s.length - 1
        var j = t.length - 1
        var res = true
        
        while(res && (i >= 0 || j >= 0)) {
            val ni = next(s, i)
            val nj = next(t, j)
            val ci = if (ni >= 0) s.charAt(ni) else ' '
            val cj = if (nj >= 0) t.charAt(nj) else ' '
            
            res &&= ci == cj
            
            i = ni - 1
            j = nj - 1
        }
        
        res && i < 0 && j < 0
    }
    
    def next(s: String, i: Int): Int = {
        if (i < 0) i
        else {
            var cnt = if (s.charAt(i) == '#') -1 else 1
            var idx = i - 1

            while (cnt <= 0 && idx >= 0) {
                cnt += (if (s.charAt(idx) == '#') - 1 else 1)
                idx -= 1
            }

            if (cnt > 0) idx + 1 else -1
        }
    }
}