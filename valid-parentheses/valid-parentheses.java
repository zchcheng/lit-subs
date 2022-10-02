class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> pair = Map.of('(', ')', '{', '}', '[', ']');
        Deque<Character> stack = new LinkedList<>();
           
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (pair.containsKey(c)) {
                stack.push(pair.get(c));
            } else {
                if (stack.isEmpty() || stack.peek() != c) return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}