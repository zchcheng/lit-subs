
import scala.collection.mutable._

object Solution {
    def ladderLength(beginWord: String, endWord: String, wordList: List[String]): Int = {
        val graph: Map[String, Set[String]] = Map()

        (wordList :+ beginWord).foreach { w1 =>
            val set: Set[String] = Set()

            wordList.foreach { w2 =>
                if (w1 != w2 && isConnected(w1, w2)) {
                    set += w2
                }
            }

            graph += (w1 -> set)
        }

        val visited: Set[String] = Set()
        val queue: Queue[String] = Queue()

        queue.enqueue(beginWord)
        visited += beginWord

        var res = 0
        var found = false

        while(!found && queue.nonEmpty) {
            val size = queue.size

            for(i <- 1 to size) {
                val word = queue.dequeue

                if (word == endWord) { found = true }
                else {
                    val connected = graph.get(word).getOrElse(Set())
                    connected.foreach { other =>
                        if (!visited.contains(other)) {
                            queue.enqueue(other)
                            visited += other
                        }
                    }
                }
            }

            res += 1
        }

        if (found) res else 0
    }

    def isConnected(w1: String, w2: String): Boolean = {
        if (w1.length == w2.length) {
            var diff = 0

            for(i <- 0 to w1.length - 1) {
                diff += (if (w1.charAt(i) != w2.charAt(i)) 1 else 0)
            }

            diff == 1
        } else false
    }
}