import scala.collection.mutable._

object Solution {
  def combinationSum(candidates: Array[Int], target: Int): List[List[Int]] = {
    val sorted = candidates.sorted
    helper(target, sorted, Map())
  }

  def helper(
      num: Int,
      cand: Array[Int],
      map: Map[Int, List[List[Int]]],
  ): List[List[Int]] = {
    val res = map.get(num).getOrElse {
      var res: List[List[Int]] = List()
        
      cand.foreach { c =>
        if (num == c) { res = res :+ List(c) } 
        else if (num > c) {
          val sub = helper(num - c, cand, map)
          sub.collect {  case s if s(0) >= c => c +: s }.foreach { s => res = res :+ s }
        }
      }
        
      res
    }
      
    map += (num -> res)
    res
  }
}