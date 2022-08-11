class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        
        if (strs.length == 0) return sb.toString();
        
        for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            boolean isSameChar = true;
            
            for(String s : strs) {
                if (s.length() <= i || s.charAt(i) != c) {
                    isSameChar = false;
                    break;
                }
            }
            
            if (isSameChar) sb.append(c);
            else break;
        }
        
        return sb.toString();
    }
}