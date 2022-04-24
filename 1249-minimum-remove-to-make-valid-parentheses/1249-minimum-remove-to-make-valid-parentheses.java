class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int stack = 0;
        
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            
            if (c == '(') {
                stack++;
            } else if (c == ')') {
                stack--;
                if (stack < 0) {
                    stack = 0;
                    continue;
                }
            }
            
            sb.append(c);
        }
        
        for (int i = sb.length() - 1; i >= 0 && stack > 0; i--) {
            if (sb.charAt(i) != '(') continue;
            sb.deleteCharAt(i);
            stack--;
        }
        
        return sb.toString();
    }
}