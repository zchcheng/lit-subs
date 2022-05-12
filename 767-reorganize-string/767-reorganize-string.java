class Solution {
    public String reorganizeString(String s) {
        int[] bucket = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            bucket[(int)c - 'a']++;
        }
        
        List<int[]> list = new ArrayList<>();
        int[] max = new int[] {-1, -1};
        for(int i = 0; i < 26; i++) {
            if (bucket[i] == 0) continue;
            list.add(new int[] {i, bucket[i]});
            if (bucket[i] > max[1]) {
                max = new int[] {list.size() - 1, bucket[i]};
            }
        }
        
        if (max[1] > (s.length() + 1) / 2) return "";
        
        Collections.swap(list, 0, max[0]);
        
        char[] res = new char[s.length()];
        
        for(int i = 0, idx = 0; i < list.size(); i++) {
            int[] p = list.get(i);
            for(int j = 0; j < p[1]; j++) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char)(p[0] + 'a');
                idx += 2;
            }
        }
        
        return String.valueOf(res);
    }
}