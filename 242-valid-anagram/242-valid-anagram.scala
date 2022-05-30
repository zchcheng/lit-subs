object Solution {
    def isAnagram(s: String, t: String): Boolean = {
        val cnt = Array.fill(26) {0}
        
        s.foreach { x =>
            val idx: Int = x - 'a'
            cnt(idx) += 1
        }
        
        t.foreach { x =>
            val idx: Int = x - 'a'
            cnt(idx) -= 1
        }
        
        cnt.map(_ == 0).reduce(_ && _)
    }
}