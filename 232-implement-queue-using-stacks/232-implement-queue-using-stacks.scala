import scala.collection.mutable._

class MyQueue() {
    var stack: Stack[Int] = Stack()

    def push(x: Int) {
        stack.push(x)
    }

    def pop(): Int = {
        val reversed = dump(stack)
        val res = reversed.pop()
        stack = dump(reversed)
        res
    }

    def peek(): Int = {
        val reversed = dump(stack)
        val res = reversed.top
        stack = dump(reversed)
        res
    }

    def empty(): Boolean = {
        stack.isEmpty
    }

    private def dump(stack: Stack[Int]): Stack[Int] = {
        val res: Stack[Int] = Stack()
        
        while(stack.nonEmpty) {
            res.push(stack.pop)
        }
        
        res
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = new MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */