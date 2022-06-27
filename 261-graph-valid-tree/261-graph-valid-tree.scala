import scala.collection.mutable._

object Solution {
    def validTree(n: Int, edges: Array[Array[Int]]): Boolean = {
        val group: Array[Int] = Array.fill(n)(0)
        
        for(i <- 0 to n - 1) group(i) = i 
        
        def find(i: Int): Int = {
            if (group(i) != i) {
                val gid = find(group(i)) 
                group(i) = gid
                gid
            } else i
        }
        
        def union(a: Int, b: Int): Boolean = {
            val ga = find(a)
            val gb = find(b)
            
            if (ga == gb) false 
            else {
                group(ga) = gb
                true
            }
        }
        
        var hasLoop = false
        edges.foreach { edge => hasLoop ||= !union(edge(0), edge(1)) }
        
        !hasLoop && ((0 to n - 1).map(find(_)).toSet.size == 1)
    }
}