class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> freq = new HashMap<>();
        Set<String> bs = new HashSet<>();
        
        Set<Character> symbols = Set.of('!', '?', ',', '\'', ';', '.', ' ');
        
        for(String b : banned) bs.add(b);
        
        String current = "";
        for(int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (symbols.contains(c)) {
                if (!current.isEmpty() && !bs.contains(current)) 
                    freq.put(current, freq.getOrDefault(current, 0) + 1);
                current = "";
                continue;
            }
            
            if (c < 'a') {
                c = (char)('a' + (int)(c - 'A'));
            }
            
            current += c;
        }
        
        if (!current.isEmpty() && !bs.contains(current)) 
            freq.put(current, freq.getOrDefault(current, 0) + 1);
        
        String result = "";
        int f = 0;
        
        for(Map.Entry<String, Integer> kv : freq.entrySet()) {
            if (kv.getValue() <= f) continue;
            
            result = kv.getKey();
            f = kv.getValue();
        }
        
        return result;
    }
}