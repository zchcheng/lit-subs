class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        Map<Character, Character> pairs = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
        );
        
        for(char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                if (stk.isEmpty() || stk.peek() != pairs.get(c)) return false;
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        
        return stk.isEmpty();
    }
}