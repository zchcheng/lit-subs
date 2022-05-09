class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, int[]> map = new HashMap<>();
        
        for(char c : p.toCharArray()) {
            int[] cnt = map.computeIfAbsent(c, i -> new int[] {0, 0});
            cnt[1]++;
        }
        
        int pn = p.length();
        int sn = s.length();
        
        for(int i = 0, lack = pn; i < sn; i++) {
            char c = s.charAt(i);
            
            if (map.containsKey(c)) {
                int[] cnt = map.get(c);
                if (++cnt[0] <= cnt[1]) {
                    lack--;
                }
            }
            
            if (i - pn >= 0) {
                char cr = s.charAt(i - pn);
                if (map.containsKey(cr)) {
                    int[] cnt = map.get(cr);
                    if (--cnt[0] < cnt[1]) {
                        lack++;
                    }
                }
            }
            
            if (lack == 0) {
                res.add(i - pn + 1);
            }
        }
        
        return res;
    }
}