class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        int next = 2;
        int ptr = 0;
        
        for(int i = 1; i <= n; i++) {
            if (i == next) {
                next *= 2;
                result[i] = 1;
                ptr = 1;
                continue;
            }
            result[i] = result[ptr++] + 1;
        }
        
        return result;
    }
}