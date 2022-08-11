public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 1, j = 0; j < 32; i <<= 1, j += 1) res += ((i & n) == 0)? 0 : 1;
        return res;
    }
}