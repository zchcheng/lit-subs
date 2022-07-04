import scala.collection.mutable._

object Solution {
    def generateParenthesis(n: Int): List[String] = {
        val res: ListBuffer[String] = ListBuffer()

        if (n == 0) {
            res += ""
        } else {
            for (i <- 0 to n - 1) {
                for(left <- generateParenthesis(i)) {
                    for(right <- generateParenthesis(n - i - 1)) {
                        res += s"${left}(${right})"
                    }
                }
            }
        }
        
        res.toList
    }
}