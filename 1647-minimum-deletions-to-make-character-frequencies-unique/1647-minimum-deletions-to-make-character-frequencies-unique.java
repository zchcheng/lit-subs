class Solution {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt[c - 'a']++;
        }
        
        List<Integer> freq = new ArrayList<>();
        
        for(int i = 0; i < 26; i++) {
            if (cnt[i] > 0) freq.add(cnt[i]);
        }
        
        freq.sort(Collections.reverseOrder());
        
        int res = 0;
        
        for(int i = 1, max = freq.get(0) - 1; i < freq.size(); i++) {
            int f = freq.get(i);
            res += Math.max(0, f - max);
            max = Math.max(0, Math.min(max, f) - 1);
        }
        
        return res;
    }
}