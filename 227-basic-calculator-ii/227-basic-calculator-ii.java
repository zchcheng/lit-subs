class Solution {
    public int calculate(String s) {
        s = s.replace(" ", "");
        
        char[] charArr = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        
        {
            int[] p = getNextNumber(charArr, 0);
            int n = p[0];
            i = p[1];
            stack.push(n);
        }
        
        for(; i < charArr.length;) {
            char c = charArr[i++];
            int[] p = getNextNumber(charArr, i);
            int n = p[0];
            i = p[1];
            
            if (c == '+') {
                stack.push(n);
                continue;
            }
            
            if (c == '-') {
                stack.push(-n);
                continue;
            }
            
            if (c == '*') {
                stack.push(stack.pop() * n);
                continue;
            }
            
            if (c == '/') {
                stack.push(stack.pop() / n);
                continue;
            }
        }
        
        int res = 0;
        
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        
        return res;
    }
    
    int[] getNextNumber(char[] arr, int curIdx) {
        int s = 0;
        
        int i = curIdx;
        for(; i < arr.length && Character.isDigit(arr[i]); i++) {
            s = s * 10 + Character.getNumericValue(arr[i]);
        }
        
        return new int[] { s, i };
    }
}