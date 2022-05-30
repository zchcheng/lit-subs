import scala.collection.mutable._

class MinStack() {
    val stack: Stack[(Int, Int)] = Stack()

    def push(v: Int) {
        if (stack.nonEmpty) {
            stack.push((v, (stack.top._2 min v)))
        } else {
            stack.push((v, v))
        }
    }

    def pop() {
        stack.pop
    }

    def top(): Int = {
        stack.top._1
    }

    def getMin(): Int = {
        stack.top._2
    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(`val`)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */