import scala.collection.mutable._

class Trie() {
    val root: TrieNode = new TrieNode()

    def insert(word: String) {
        root.insert(word, 0)
    }

    def search(word: String): Boolean = {
        root.find(word, 0).map(_.set.contains(word)).getOrElse(false)
    }

    def startsWith(prefix: String): Boolean = {
        root.find(prefix, 0).isDefined
    }

}

class TrieNode() {
    val set: Set[String] = Set()
    val map: Map[Char, TrieNode] = Map()
    
    def insert(word: String, index: Int) {
        if (index == word.length) {
            set += word
        } else {
            val c = word.charAt(index)
            val next = map.get(c).getOrElse(new TrieNode())
            map += (c -> next)
            next.insert(word, index + 1)
        }
    }
    
    def find(word: String, index: Int): Option[TrieNode] = {
        if (index == word.length) {
            Some(this)
        } else {
            map.get(word.charAt(index)).flatMap(_.find(word, index + 1))
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = new Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */