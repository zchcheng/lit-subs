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
            
            long k = Math.max(books[i] - (i - j - 1), 1);
            
            long s = ssum(books[i], k);
            
            System.out.println(i + ", " + j + ", " + k + ", " + s + ", " + (s + v));
            
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