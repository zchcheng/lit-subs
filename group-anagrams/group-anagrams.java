class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        
        for(String str : strs) {
            List<String> list = group.computeIfAbsent(encode(str), k -> new ArrayList<>());
            list.add(str);
        }
        
        List<List<String>> result = new ArrayList<>();
        
        for(Map.Entry<String, List<String>> kv : group.entrySet()) {
            result.add(kv.getValue());
        }
        
        return result;
    }
    
    String encode(String str) {
        int[] frequency = new int[26];
        
        for(char c : str.toCharArray()) {
            frequency[(int)c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 26; i++) {
            sb.append(frequency[i] + " ");
        }
        
        return sb.toString();
    }
}