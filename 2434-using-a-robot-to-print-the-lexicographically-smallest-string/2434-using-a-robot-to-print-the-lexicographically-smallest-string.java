class Solution {
    public String robotWithString(String s) {
        // b a c
        // a a c
        // a b
        // 
        
        int n = s.length();
        
        char[] arr = new char[n];
        arr[n - 1] = s.charAt(n - 1);
        
        for(int i = n - 2; i >= 0; i--) arr[i] = (arr[i + 1] < s.charAt(i))? arr[i + 1] : s.charAt(i);
        
        Deque<Character> stack = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                result.append(stack.pop());
            }
            stack.push(s.charAt(i));
        }
        
        while(!stack.isEmpty()) result.append(stack.pop());
        
        return result.toString();
    }
}