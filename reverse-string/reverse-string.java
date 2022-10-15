class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        
        while(l < r) {
            swap(s, l++, r--);
        }
    }
    
    void swap(char[] s, int a, int b) {
        char tmp = s[a];
        s[a] = s[b];
        s[b] = tmp;
    }
}