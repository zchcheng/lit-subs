import scala.collection.mutable._

object Solution {
    def longestCommonPrefix(strs: Array[String]): String = {
        var done = false
        var res = ""
        var i = 0
        
        while(!done) {
            var set = Set[Char]()
            
            strs.foreach { str =>
                if (str.size > i) set += str.charAt(i)
                else done = true
            }
            
            if (set.size > 1) {
                done = true
            } 
            
            if (!done) {
                res += set.head
                i += 1
            }
        }
        
        res
    }
}