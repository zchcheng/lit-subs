class Solution {
    public boolean equalFrequency(String word) {
        int[] freq = new int[26];
        
        for(char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int f : freq) {
            if (f == 0) continue;
            map.put(f, map.getOrDefault(f, 0) + 1);
        }
        
        Set<Integer> keys = new HashSet<>(map.keySet());
        
        for(int k : keys) {
            int n = map.get(k);

            if (k == 1 && map.size() == 1) return true;
            
            if (n == 1) {
                map.remove(k);
                
                if (k != 1) map.put(k - 1, map.getOrDefault(k - 1, 0) + 1);
                
                if (map.size() == 1) return true;
                
                if (k != 1) {
                    if (map.getOrDefault(k - 1, 0) == 1) map.remove(k - 1);
                    else map.put(k - 1, map.get(k - 1) - 1);
                }
                
                map.put(k, 1);
            }
        }
        
        return false;
    }
}