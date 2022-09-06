class Solution {
    public String minWindow(String s, String t) {
        List<int[]> words = new ArrayList<>();
        
        Map<Character, int[]> map = new HashMap<>();
        
        int lack = t.length();
        for(char c : t.toCharArray()) {
            int[] n = map.computeIfAbsent(c, k -> new int[2]);
            n[0]++;
        }
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) words.add(new int[] {c - 'A', i});
        }
        
        int[] range = null;
        
        for(int i = 0, l = -1; i < words.size(); i++) {
            int[] p = words.get(i);
            char c = (char)('A' + p[0]);
            int[] cnt = map.get(c);
            
            cnt[1]++;
            
            if (cnt[1] <= cnt[0]) lack--;
            
            while(lack <= 0) {
                l++;
                
                if (range == null || range[1] - range[0] + 1 > words.get(i)[1] - words.get(l)[1] + 1) {
                    range = new int[] { words.get(l)[1], words.get(i)[1] };
                }
                
                int[] tr = words.get(l);
                char trc = (char)('A' + tr[0]);
                int[] rcnt = map.get(trc);
                rcnt[1]--;
                
                if (rcnt[1] < rcnt[0]) lack++;
            }
        }
        
        return (range == null)? "" : s.substring(range[0], range[1] + 1);
    }
}