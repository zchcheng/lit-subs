class Solution {
    public int minimumKeypresses(String s) {
        Integer[] bucket = new Integer[26];
        Arrays.fill(bucket, 0);
        
        for(char c : s.toCharArray()) {
            bucket[(int)(c - 'a')]++;
        }
        
        int cnt = 0;
        int mul = 1;
        
        Arrays.sort(bucket, (a, b) -> b - a);
        
        int result = 0;
        
        for(int i = 0; i < 26; i++) {
            if (bucket[i] == 0) break;
            
            result += mul * bucket[i];
            
            if (++cnt % 9 == 0) mul++;
        }
        
        return result;
    }
}