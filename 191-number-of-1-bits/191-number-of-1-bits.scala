object Solution {
    // you need treat n as an unsigned value
    def hammingWeight(n: Int): Int = {
        Integer.bitCount(n)
    }
}
