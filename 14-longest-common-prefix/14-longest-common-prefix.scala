object Solution {
    def longestCommonPrefix(strs: Array[String]): String = {
        var res = ""
        var i = 0
        var done = false;

        while (!done) {
            val set = strs.map { x => if (x.length <= i) '0' else x.charAt(i) }.toSet
            if (set.size == 1 && set.head != '0') res += set.head else done = true
            i += 1
        }

        res
    }
}