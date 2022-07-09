import scala.collection.mutable._

object Solution {
    def asteroidCollision(asteroids: Array[Int]): Array[Int] = {
        val stack: Stack[Int] = Stack()

        asteroids.foreach { a =>
            if (a > 0) {
                stack.push(a)
            } else {
                while(stack.nonEmpty && stack.top > 0 && stack.top + a < 0) {
                    stack.pop()
                }
                if (stack.isEmpty || stack.top < 0) stack.push(a)
                if (stack.top == -a) stack.pop()
            }
        }

        stack.toArray.reverse
    }
}