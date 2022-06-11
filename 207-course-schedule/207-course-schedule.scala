import scala.collection.mutable._

object Solution {
    
    def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
        val map: Map[Int, List[Int]] = Map()
        
        prerequisites.foreach { p => 
            var list = map.get(p(0)).getOrElse(List())
            map += (p(0) -> (list :+ p(1)))
        }
        
        val checked: Array[Boolean] = Array.fill(numCourses)(false)
        var res = true
        var i = 0
        while(res && i < numCourses) {
            res &&= helper(i, checked, Array.fill(numCourses)(false), map)
            i += 1
        }
        res
    }
    
    def helper(i: Int, checked: Array[Boolean], visited: Array[Boolean], prep: Map[Int, List[Int]]): Boolean = {
        if (checked(i)) true
        else if (visited(i)) false
        else {
            visited(i) = true
            var canFinish = true
            var j = 0
            val list = prep.get(i).getOrElse(List())
            
            while (canFinish && j < list.length) {
                canFinish &&= helper(list(j), checked, visited, prep)
                j += 1
            }
            
            visited(i) = false
            checked(i) = canFinish
            canFinish
        }
    }
}