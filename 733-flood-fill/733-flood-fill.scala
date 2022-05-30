import scala.collection.mutable._

object Solution {
    def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
        val c = image(sr)(sc)
        var q: List[Array[Int]] = Nil
        var next = (0, 1) :: (0, -1) :: (1, 0) :: (-1, 0) :: Nil
        
        if (c != newColor) {
            q = q :+ Array(sr, sc)
        }
        
        while(q.nonEmpty) {
            val p :: rest = q
            q = rest
            
            image(p(0))(p(1)) = newColor
            
            next.foreach { np =>
                val nr = p(0) + np._1
                val nc = p(1) + np._2
                if (nr >= 0 && nr < image.length && nc >= 0 && nc < image(0).length && image(nr)(nc) == c) {
                    q = q :+ Array(nr, nc)
                }
            }
        }
        
        image
    }
}