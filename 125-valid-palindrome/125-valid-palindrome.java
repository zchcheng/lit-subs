class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        
        for(int i = 0, j = arr.length - 1; i < j; i++, j--) {
            while(i < j && !isAlphaNumeric(arr[i])) {
                i++;
            }
            
            while(i < j && !isAlphaNumeric(arr[j])) {
                j--;
            }
            
            if (i != j && Character.toUpperCase(arr[i]) != Character.toUpperCase(arr[j])) {
                return false;
            }
        }
        
        return true;
    }
    
    boolean isAlphaNumeric(char c) {
        return Character.isAlphabetic(c) || Character.isDigit(c);
    }
}