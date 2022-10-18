class Solution {
    public String longestPalindrome(String s) {
        int[] r = new int[] {1, -1};
        
        for(int i = 0; i < s.length(); i++) {
            int[] t = check(s, i);
            if (t[1] - t[0] > r[1] - r[0]) r = t;
        }
        
        if (r[0] >= r[1]) return "";
        
        return s.substring(r[0] + 1, r[1]);
    }
    
    int[] check(String s, int i) {
        int[] a = check(s, i - 1, i + 1, 1);
        int[] b = check(s, i - 1, i, 0);
        
        if (a[1] - a[0] > b[1] - b[0]) return a;
        return b;
    }
    
    int[] check(String s, int l, int r, int init) {
        while(l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else break;
        }
        return new int[] { l, r };
    }
}