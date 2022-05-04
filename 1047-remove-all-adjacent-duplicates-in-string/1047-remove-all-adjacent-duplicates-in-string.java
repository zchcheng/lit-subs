class Solution {
    public String removeDuplicates(String s) {
        Stack<String> stack = new Stack<String>();
        char[] arr = s.toCharArray();
        
        for(char c : arr) {
            String sc = String.valueOf(c);
            if (!stack.isEmpty() && stack.peek().equals(sc)) {
                stack.pop();
                continue;
            }
            stack.push(sc);
        }
        
        return String.join("", stack.toArray(String[]::new));
    }
}