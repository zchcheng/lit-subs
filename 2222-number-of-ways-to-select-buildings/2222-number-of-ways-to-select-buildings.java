class Solution {
    public long numberOfWays(String s) {
        // 0: 0
        // 1: 0
        //           0
        //           0
        // 0 0 1 1 0 1
        
        long result = 0;
        int n = s.length();
        
        long[] n0 = new long[n + 1];
        long[] n1 = new long[n + 1];
        long[] n01 = new long[n + 1];
        long[] n10 = new long[n + 1];
        
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            
            if (c == '1') {
                result += n01[i + 1];
                n10[i] = n10[i + 1] + n0[i + 1];
                n1[i] = n1[i + 1] + 1;
                
                n01[i] = n01[i + 1];
                n0[i] = n0[i + 1];
            } else {
                result += n10[i + 1];
                n01[i] = n01[i + 1] + n1[i + 1];
                n0[i] = n0[i + 1] + 1;
                
                n10[i] = n10[i + 1];
                n1[i] = n1[i + 1];
            }
        }
        
        return result;
    }
}