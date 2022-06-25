import scala.collection.mutable._

class LRUCache(_capacity: Int) {
    case class DL(val key: Int, var value: Int, var prev: DL = null, var next: DL = null)

    val head: DL = DL(-1, -1)
    val tail: DL = DL(-1, -1)
    head.prev = tail
    tail.next = head
    val map: Map[Int, DL] = Map()

    def get(key: Int): Int = {
        map.get(key)
            .map { node =>
                remove(node)
                putHead(node)
                node
            }
            .map(_.value)
            .getOrElse(-1)
    }

    def put(key: Int, value: Int):Unit = {
        if (map.contains(key)) {
            val node = map.get(key).get
            node.value = value
            remove(node)
            putHead(node)
        } else {
            val node = DL(key, value)
            map += (key -> node)
            putHead(node)

            if (map.size > _capacity) {
                val toBeRemoved = tail.next
                map.remove(toBeRemoved.key)
                remove(toBeRemoved)
            }
        }
    }

    private def remove(node: DL): Unit = {
        node.prev.next = node.next
        node.next.prev = node.prev
    }

    private def putHead(node: DL): Unit = {
        node.next = head
        node.prev = head.prev
        head.prev = node
        node.prev.next = node
    }

}


/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = new LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */