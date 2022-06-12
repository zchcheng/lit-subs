import scala.collection.mutable._

object Solution {
  def accountsMerge(accounts: List[List[String]]): List[List[String]] = {
    val map: Map[String, ListBuffer[List[String]]] = Map()

    accounts.foreach { acc =>
      val name = acc(0)
      val emails = acc.slice(1, acc.length)
      val list = map.getOrElse(name, ListBuffer())
      list += emails
      map += (name -> list)
    }

    val res: ListBuffer[List[String]] = ListBuffer()

    map.foreach { kv =>
      val lists = join(kv._2.toList)
      lists.foreach { list =>
        res += kv._1 :: list
      }
    }

    res.toList
  }

  private def join(lists: List[List[String]]): List[List[String]] = {
    val map: Map[String, List[Int]] = Map()
    val group: Array[Int] = Array.fill(lists.length)(0)

    for (i <- 0 to lists.length - 1) {
      group(i) = i
      lists(i).foreach { email =>
        val grps = map.getOrElse(email, List())
        map += (email -> (grps :+ i))
      }
    }

    map.foreach { kv =>
      val grps = kv._2
      for (i <- 0 to grps.length - 2) {
        val id1 = grps(i)
        for (j <- i to grps.length - 1) {
          val id2 = grps(j)
          union(id1, id2, group)
        }
      }
    }

    val map2: Map[Int, Set[String]] = Map()

    for (i <- 0 to lists.length - 1) {
      val id = find(i, group)
      val set = map2.getOrElse(id, Set())
      set ++= lists(i)
      map2 += (id -> set)
    }

    map2.map(_._2.toList.sorted).toList
  }

  private def find(id: Int, group: Array[Int]): Int = {
    if (group(id) == id) id
    else {
      val pid = find(group(id), group)
      group(id) = pid
      pid
    }
  }

  private def union(id1: Int, id2: Int, group: Array[Int]): Unit = {
    val pid1 = find(id1, group)
    val pid2 = find(id2, group)
    group(pid1) = pid2
  }
}