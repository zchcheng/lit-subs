class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            while(i < j && !isValidChar(s.charAt(i))) i++;
            while(i < j && !isValidChar(s.charAt(j))) j--;
            
            if (i >= j) break;
            
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            
            i += 1;
            j -= 1;
        }
        
        return true;
    }
    
    boolean isValidChar(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
}