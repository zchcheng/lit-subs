class Solution {
    public long maximumBooks(int[] books) {
        Deque<Integer> stack = new LinkedList<>();
        long result = 0;
        long[] dp = new long[books.length];
        
        for(int i = 0; i < books.length; i++) {
            int j = i - 1;
            
            while(!stack.isEmpty() && books[stack.peek()] >= books[i] - (i - stack.peek())) {
                stack.pop();
                
                if (stack.isEmpty()) j = -1;
                else j = stack.peek();
            }
            
            long v = (j == -1)? 0 : dp[j];
            long s = ssum(books[i], Math.max(books[i] - (i - j - 1), 1));
            
            dp[i] = s + v;
            
            result = Math.max(result, dp[i]);
            
            stack.push(i);
        }
        
        return result;
    }
    
    long ssum(long s, long e) {
        return (s + e) * (s - e + 1) / 2;
    }
}