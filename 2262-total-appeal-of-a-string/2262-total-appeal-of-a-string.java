class Solution {
    public long appealSum(String s) {
        int[] prevIdx = new int[26];
        
        Arrays.fill(prevIdx, -1);
        
        int[] roc = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            int pi = prevIdx[c];
            
            roc[i] = pi + 1;
            prevIdx[c] = i;
        }
        
        long result = 0;
        
        for(int i = 0; i < s.length(); i++) {
            result += (long)(i - roc[i] + 1) * (s.length() - i);
        }
        
        return result;
    }
}