class Solution {
    int[] pair;
    char[] arr;
    
    public String decodeString(String s) {
        arr = s.toCharArray();
        
        pair = new int[arr.length];
        
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == '[') { stack.push(i); }
            if (c == ']') { pair[stack.pop()] = i; }
        }
        
        return helper(0, arr.length - 1);
    }
    
    String helper(int s, int e) {
        StringBuilder sb = new StringBuilder();
        int n = 0;
        
        for(int i = s; i <= e; i++) {
            char c = arr[i];
            
            if (Character.isDigit(c)) {
                n = n * 10 + Character.getNumericValue(c);
                continue;
            }
            
            if (c == '[') {
                String sub = helper(i + 1, pair[i] - 1);
                sb.append(sub.repeat(n));
                n = 0;
                i = pair[i];
                continue;
            }
            
            sb.append(c);
        }
        
        return sb.toString();
    }
}