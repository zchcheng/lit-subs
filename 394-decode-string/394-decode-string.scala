object Solution {
    def decodeString(s: String): String = {
        var mul = 0
        var idx = 0
        var res: String = ""
        
        while(idx < s.length) {
            val c = s.charAt(idx)

            if (c.isDigit)  mul = mul * 10 + c.getNumericValue
            else if (c == '[') {
                var stack = 1
                var eidx = idx + 1
                
                while(stack != 0) {
                    if (s.charAt(eidx) == '[') stack += 1
                    else if (s.charAt(eidx) == ']') stack -= 1
                    if (stack != 0) eidx += 1
                }
                
                res = res.concat(decodeString(s.subSequence(idx + 1, eidx).toString) * mul)
                idx = eidx
                mul = 0
            } else res += c

            idx += 1
        }

        res
    }
}