/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var neighbors: List[Node] = List()
 * }
 */

import scala.collection.mutable._

object Solution {
    def cloneGraph(graph: Node): Node = {
        if (graph != null) clone(graph, Map()) else null
    }
    
    def clone(graph: Node, map: Map[Int, Node]): Node = {
        map.get(graph.value).getOrElse {
            val node = new Node(graph.value)
            map += (node.value -> node)
            node.neighbors = graph.neighbors.map(clone(_, map))
            node
        }
    }
}