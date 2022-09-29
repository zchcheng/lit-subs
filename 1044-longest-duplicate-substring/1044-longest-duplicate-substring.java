class Solution {
    public String longestDupSubstring(String s) {
        int l = 0;
        int r = s.length();
        
        String result = "";
        
        while(l <= r) {
            int m = l + (r - l) / 2;
            
            String pat = findDupPattern(s, m);
            
            if (pat == null) {
                r = m - 1;
            } else {
                if (result.length() < m) result = pat;
                l = m + 1;
            }
        }
        
        return result;
    }
    
    String findDupPattern(String s, int window) {
        final long mod = (long)1e9 + 7;
        
        Map<Long, List<Integer>> visited = new HashMap<>();
        long current = 0;
        long k = 1;
        
        for(int i = 1; i <= window; i++) k = (26 * k) % mod;
        
        for(int i = 0; i < s.length(); i++) {
            long v = s.charAt(i) - 'a';
            current = (current * 26 + v) % mod;
            
            if (i >= window) {
                long rv = s.charAt(i - window) - 'a';
                current = (current - rv * k % mod + mod) % mod;
            }
            
            if (i < window - 1) continue;
            
            if (visited.containsKey(current)) {
                List<Integer> list = visited.get(current);
                String pat = s.substring(i - window + 1, i + 1);
                
                for(int idx : list) {
                    if (s.substring(idx, idx + window).equals(pat)) return pat;
                }
            }
            
            visited.computeIfAbsent(current, n -> new ArrayList<>()).add(i - window + 1);
        }
        
        return null;
    }
}