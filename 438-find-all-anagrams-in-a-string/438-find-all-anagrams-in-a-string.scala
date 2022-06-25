import scala.collection.mutable._

object Solution {
  def findAnagrams(s: String, p: String): List[Int] = {
    val map: Map[Char, Int] = Map()
    val res: ListBuffer[Int] = ListBuffer()

    p.foreach { c => map += (c -> (map.get(c).getOrElse(0) - 1)) }

    val bucket: Bucket = new Bucket(map, p.length)

    if (p.length > 1)
      for (i <- 0 to p.length - 2) {
          if (i < s.length) {
              val c = s.charAt(i)
              bucket.add(c)
          }
      }

    if (p.length <= s.length)
     for (i <- p.length - 1 to s.length - 1) {
       var c = s.charAt(i)
       if (bucket.add(c)) res += i - p.length + 1
       c = s.charAt(i - p.length + 1)
       bucket.remove(c)
     }

    res.toList
  }

  class Bucket(map: Map[Char, Int], n: Int) {
    private var l = n

    def add(c: Char): Boolean = {
      if (map.contains(c)) {
        val n = map.get(c).get
        map += (c -> (n + 1))
        if (n + 1 <= 0) l -= 1
      }
      l == 0
    }

    def remove(c: Char): Unit = {
      if (map.contains(c)) {
        val n = map.get(c).get
        map += (c -> (n - 1))
        if (n - 1 < 0) l += 1
      }
    }
  }
}