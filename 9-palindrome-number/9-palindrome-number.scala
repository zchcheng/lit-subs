object Solution {
    def isPalindrome(x: Int): Boolean = {
        val str = x.toString
        var res = true
        for(i <- 0 to (str.length / 2) - 1) {
            res &&= str.charAt(i) == str.charAt(str.length - 1 - i)
        }
        res
    }
}