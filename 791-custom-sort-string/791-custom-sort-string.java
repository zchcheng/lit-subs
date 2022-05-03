class Solution {
    public String customSortString(String order, String s) {
        int[] bucket = new int[26];
        
        for(char c : s.toCharArray()) {
            bucket[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : order.toCharArray()) {
            append(sb, c, bucket);
        }
        
        for(int i = 0; i < bucket.length; i++) {
            append(sb, (char)('a' + i), bucket);
        }
        
        return sb.toString();
    }
    
    void append(StringBuilder sb, char c, int[] bucket) {
        while(bucket[c - 'a'] > 0) {
            sb.append(c);
            bucket[c - 'a']--;
        }
    }
}