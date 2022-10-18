class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        
        for(String s : strs) {
            String k = serialize(s);
            m.computeIfAbsent(k, p -> new ArrayList<>()).add(s);
        }
        
        List<List<String>> res = new ArrayList<>(m.values());
        
        return res;
    }
    
    String serialize(String s) {
        int[] cnt = new int[26];
        
        for(char c : s.toCharArray()){ 
            cnt[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int c : cnt) sb.append(c + " ");
        
        return sb.toString();
    }
}