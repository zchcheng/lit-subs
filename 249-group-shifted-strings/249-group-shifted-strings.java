class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        
        for(String s : strings) {
            String enc = encode(s);
            List<String> list = map.computeIfAbsent(enc, i -> new ArrayList<>());
            list.add(s);
        }
        
        return new LinkedList<>(map.values());
    }
    
    String encode(String s) {
        int n = s.length();
        String[] arr = new String[n];
        char p = s.charAt(0);
        
        for(int i = 1; i < n; i++) {
            char c = s.charAt(i);
            arr[i] = String.valueOf(((c - p) + 26) % 26);
        }
        
        return String.join(",", arr);
    }
}