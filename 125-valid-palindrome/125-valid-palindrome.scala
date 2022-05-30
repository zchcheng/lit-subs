object Solution {
    def isPalindrome(s: String): Boolean = {
        var i = 0
        var j = s.length - 1
        var res = true
        
        while(i < j) {
            while (i < j && !s.charAt(i).isLetter && !s.charAt(i).isDigit) { i += 1 }
            while (i < j && !s.charAt(j).isLetter && !s.charAt(j).isDigit) { j -= 1 }
            
            res &&= s.charAt(i).toLower == s.charAt(j).toLower
            
            i += 1
            j -= 1
        }
        
        res
    }
}