import scala.collection.mutable._

object Solution {
    def calculate(s: String): Int = {
        val stack: Stack[Int] = Stack()

        var num = 0
        var sign = 1
        var cur = 0

        s.foreach { c =>
            c match {
                case '(' =>
                    stack.push(cur)
                    stack.push(sign)
                    sign = 1
                    cur = 0
                case ')' =>
                    val psign = stack.pop()
                    val prev = stack.pop()
                    cur += sign * num
                    cur = cur * psign + prev
                    sign = 1
                    num = 0
                case op if op == '+' || op == '-' =>
                    cur += sign * num
                    sign = if (op == '+') 1 else -1
                    num = 0
                case d if d.isDigit =>
                    num = num * 10 + d.getNumericValue
                case _ => 
            }
        }

        cur + sign * num
    }
}