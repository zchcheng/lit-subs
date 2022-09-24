class Solution {
    public int largestVariance(String s) {
        int[] lastIndex = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        int res = 0;
        
        for(int i = 0; i < 26; i++) {
            char c1 = (char)('a' + i);
            
            for(int j = 0; j < 26; j++) {
                char c2 = (char)('a' + j);
                
                if (c1 == c2) continue;
                
                int cnt1 = 0;
                int cnt2 = 0;
                
                for(int k = 0; k < s.length(); k++) {
                    char c = s.charAt(k);
                    
                    if (c1 == c)  cnt1++;
                    else if (c2 == c) cnt2++;
                    
                    if (cnt2 != 0) {
                        res = Math.max(res, cnt1 - cnt2);
                    }
                    
                    if (lastIndex[c2 - 'a'] > k && cnt2 > cnt1) {
                        cnt1 = 0;
                        cnt2 = 0;
                    }
                }
            }
        }
        
        return res;
    }
}