class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[][] boundary = new int[n][2];
        
        Stack<int[]> next = new Stack<>();
        Stack<int[]> prev = new Stack<>();
        for(int i = 0; i < n; i++) {
            monoInc(arr[i], i, prev);
            monoInc(arr[n - 1 - i], n - 1 - i, next);
            
            boundary[i][0] = (prev.isEmpty())? -1 : prev.peek()[0];
            boundary[n - 1 - i][1] = (next.isEmpty())? n : next.peek()[0];
            
            prev.push(new int[] {i, arr[i]});
            next.push(new int[] {n - 1 - i, arr[n - 1 - i]});
        }
        
        long res = 0;
        long mod = 1000000007;
        
        for(int i = 0; i < n; i++) {
            res += ((long)(i - boundary[i][0]) * (long)(boundary[i][1] - i) * (long)arr[i]) % mod;
            res %= mod;
        }
        
        return (int)res;
    }
    
    void monoInc(int v, int i, Stack<int[]> stack) {
        while(!stack.isEmpty() && ((stack.peek()[1] > v) || (stack.peek()[1] == v && i < stack.peek()[0]))) {
            stack.pop();
        }
    }
}