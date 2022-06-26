import scala.collection.mutable._

object Solution {
    def groupAnagrams(strs: Array[String]): List[List[String]] = {
        val map: Map[String, ListBuffer[String]] = Map()

        strs.foreach { str =>
            val encoded = encode(str)
            val list = map.get(encoded).getOrElse(ListBuffer[String]())
            list += str
            map += (encoded -> list)
        }

        val res: ListBuffer[List[String]] = ListBuffer()

        map.foreach { kv => 
            res += kv._2.toList
        }

        res.toList
    }

    private def toInt(char: Char): Int = 
        char.asInstanceOf[Int] - 'a'.asInstanceOf[Int]
    
    private def encode(str: String): String = {
        val arr: Array[Int] = Array.fill(26)(0)
        var res = ""

        str.foreach { c => 
            arr(toInt(c)) += 1
        }
        arr.foreach { n => 
            res += n + ";"
        }

        res
    }
}