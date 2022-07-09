object Solution {
    def countComponents(n: Int, edges: Array[Array[Int]]): Int = {
        val id: Array[Int] = Array.fill(n)(0)

        for(i <- 0 to n - 1) { id(i) = i }

        def find(i: Int): Int = {
            if (id(i) != i) {
                val gi = find(id(i))
                id(i) = gi
            }
            id(i)
        }

        def union(a: Int, b: Int): Unit = {
            val ga = find(a)
            val gb = find(b)
            id(gb) = ga
        }

        edges.foreach(edge => union(edge(0), edge(1)))

        id.map(find(_)).toSet.size
    }
}