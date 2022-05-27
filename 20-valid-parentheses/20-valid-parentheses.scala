import scala.collection.mutable

object Solution {
    def isValid(s: String): Boolean = {
        var res = true
        var stack = mutable.Stack[Char]()
        var map: Map[Char, Char] = Map({ ')' -> '(' }, { '}' -> '{' }, { ']' -> '[' })

        s.foreach { c =>
            c match {
                case '(' | '[' | '{' => stack.push(c)
                case ')' | ']' | '}' => {
                    res &&= !stack.isEmpty && stack.top == map(c)
                    if (!stack.isEmpty) stack.pop()
                }
            }
        }

        res && stack.isEmpty
    }
}