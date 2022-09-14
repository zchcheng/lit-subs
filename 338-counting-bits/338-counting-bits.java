class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        
        for(int i = 1, cur = 1, p = 0; i <= n; i++, p++) {
            if (i == cur) {
                cur = cur * 2;
                res[i] = 1;
                p = 0;
                continue;
            }
            res[i] = res[p] + 1;
        }
        
        return res;
    }
}