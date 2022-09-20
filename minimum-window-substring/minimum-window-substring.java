class Solution {
    public String minWindow(String s, String t) {
        Map<Character, int[]> map = new HashMap<>();
        
        for(char c : t.toCharArray()) {
            int[] freq = map.computeIfAbsent(c, k -> new int[] {0, 0});
            freq[1]++;
        }
        
        int lack = t.length();
        int[] result = null;
        
        for(int i = 0, j = -1; i < s.length(); i++) {
            char c = s.charAt(i);
            int[] freq = map.get(c);
            
            if (freq == null) continue;
            
            if (++freq[0] <= freq[1]) lack--;
            
            while(lack <= 0) {
                if (result == null || result[1] - result[0] > i - j) {
                    result = new int[] {j, i};
                }
                
                char rc = s.charAt(++j);
                int[] frc = map.get(rc);
                
                if (frc == null) continue;
                
                if (frc[0] > 0 && --frc[0] < frc[1]) {
                    lack++;
                }
            }
        }
        
        if (result == null) return "";
        return s.substring(result[0] + 1, result[1] + 1);
    }
}