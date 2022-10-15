class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        
        while(l < r) {
            while(l < r && getAlphanumeric(s.charAt(l)) == -1) l++;
            while(l < r && getAlphanumeric(s.charAt(r)) == -1) r--;
            
            if (l < r && getAlphanumeric(s.charAt(l)) != getAlphanumeric(s.charAt(r))) return false;
            
            l++;
            r--;
        }
        
        return true;
    }
    
    int getAlphanumeric(char c) {
        if ('a' <= c && c <= 'z') return 10 + c - 'a';
        if ('A' <= c && c <= 'Z') return 10 + c - 'A';
        if ('0' <= c && c <= '9') return c - '0';
        return -1;
    }
    
    
}