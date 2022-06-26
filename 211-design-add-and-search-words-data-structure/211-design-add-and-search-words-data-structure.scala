import scala.collection.mutable._

class WordDictionary() {
    case class Trie() {
        var hasWord: Boolean = false
        val next: Map[Char, Trie] = Map()

        def getNext(c: Char): Trie = {
            next.get(c).getOrElse {
                val node = Trie()
                next += (c -> node)
                node
            }
        }
    }

    val root = Trie()

    def addWord(word: String): Unit = {
        var cur = root
        for(i <- 0 to word.length - 1) {
            val c: Char = word.charAt(i)
            cur = cur.getNext(c)
        }
        cur.hasWord = true
    }

    def search(word: String): Boolean = {
        var end = false
        var i = 0
        var cur = root
        helper(word, 0, Some(root))
    }

    
    def helper(word: String, i: Int, node: Option[Trie]): Boolean = {
        node.map { n =>
            if (i >= word.length) n.hasWord
            else {
                val c = word.charAt(i)
                if (c == '.') {
                    var res = false
                    n.next.foreach { case (c, next) => 
                        res ||= helper(word, i + 1, Some(next))
                    }
                    res
                } else helper(word, i + 1, n.next.get(c))
            }
        }.getOrElse(false)
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = new WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */