object Solution {
    def addBinary(a: String, b: String): String = {
        var i = a.length - 1
        var j = b.length - 1
        var res = ""
        var c = 0
        
        while (i >= 0 || j >= 0) {
            val v1 = if (i >= 0 && a.charAt(i) == '1') 1 else 0
            val v2 = if (j >= 0 && b.charAt(j) == '1') 1 else 0
            val s = v1 + v2 + c
            
            c = if (s >= 2) 1 else 0
            
            res += (s % 2)
            
            i -= 1
            j -= 1
        }
        
        if (c > 0) res += "1"
        
        res.reverse
    }
}