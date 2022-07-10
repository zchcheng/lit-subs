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
                    println("push: " + stack)
                    stack.push(cur)
                    stack.push(sign)
                    sign = 1
                    cur = 0
                case ')' =>
                    println("pop: " + stack)
                    val psign = stack.pop()
                    val prev = stack.pop()
                    cur += sign * num
                    println("this: " + cur)
                    cur = cur * psign + prev
                    println("cur: " + cur)
                    sign = 1
                    num = 0
                case op if op == '+' || op == '-' =>
                    println(sign + " " + num)
                    cur += sign * num
                    println("now: " + cur)
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