class Solution {
    public long appealSum(String s) {
        int[] prevIdx = new int[26];
        
        Arrays.fill(prevIdx, -1);
        
        int[][] roc = new int[s.length()][2];
        
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            int pi = prevIdx[c];
            
            //if (pi >= 0) roc[pi][1] = i;
            roc[i] = new int[] { pi + 1, s.length() - 1 };
            prevIdx[c] = i;
        }
        
        //print(roc);
        
        long result = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int[] p = roc[i];
            long k = (long)(i - (long)p[0] + 1) * (long)((long)p[1] - i + 1);
            //System.out.println(k);
            result += k;
        }
        
        return result;
    }
    
    void print(int[][] arr) {
        for(int i = 0; i < arr.length; i++)
            System.out.println("[" + arr[i][0] + ", " + arr[i][1] + "]");
    }
}