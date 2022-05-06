class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strs) {
            String enc = encode(s);
            List<String> list = map.computeIfAbsent(enc, e -> new ArrayList<>());
            list.add(s);
        }
        
        return new ArrayList<>(map.values());
    }
    
    String encode(String str) {
        int[] bucket = new int[26];
        
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            bucket[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 26; i++) {
            sb.append(bucket[i]);
            sb.append(',');
        }
        
        return sb.toString();
    }
}