import scala.collection.mutable._

object Solution {
    case class Temperature(val index: Int, val value: Int)

    def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
        val res: Array[Int] = Array.fill(temperatures.length)(0)
        val stack: Stack[Temperature] = Stack()

        for(i <- 0 to temperatures.length - 1) {
            val idx = temperatures.length - 1 - i
            val temp = temperatures(idx)

            while(stack.nonEmpty && stack.top.value <= temp) stack.pop
            res(idx) = if (stack.isEmpty) 0 else (stack.top.index - idx)
            stack.push(Temperature(idx, temp))
        }

        res
    }
}