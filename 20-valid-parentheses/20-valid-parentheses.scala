import scala.collection.mutable._

object Solution {
    def isValid(s: String): Boolean = {
        val stack: Stack[Char] = Stack()
        val map: Map[Char, Char] = Map({')' -> '('}, {']' -> '['}, {'}' -> '{'})
        var res = true
                                                               
        s.foreach { x => 
            if (map.contains(x)) {
                res &&= stack.nonEmpty && stack.top == map(x)
                if (stack.nonEmpty) stack.pop
            } else {
                stack.push(x)
            }
        }
                                                               
        res && stack.isEmpty
    }
}