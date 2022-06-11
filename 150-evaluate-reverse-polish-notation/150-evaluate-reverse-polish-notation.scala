import scala.collection.mutable._

object Solution {
    def evalRPN(tokens: Array[String]): Int = {
        val stack: Stack[Int] = Stack()
        
        tokens.foreach { tok => 
            tok match {
                case "+" => stack.push(stack.pop + stack.pop) 
                case "-" => {
                    val a = stack.pop
                    val b = stack.pop
                    stack.push(b - a)
                }
                case "*" => stack.push(stack.pop * stack.pop) 
                case "/" => {
                    val a = stack.pop
                    val b = stack.pop
                    stack.push(b / a)
                }
                case n => stack.push(n.toInt)
            }
        }
        
        stack.top
    }
}