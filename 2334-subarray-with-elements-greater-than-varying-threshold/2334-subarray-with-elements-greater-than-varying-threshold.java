class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        Stack<Integer> stackRB = new Stack<>();
        Stack<Integer> stackLB = new Stack<>();
        
        int n = nums.length;
        int[] rb = new int[n];
        int[] lb = new int[n];
        
        Arrays.fill(rb, n);
        Arrays.fill(lb, -1);
        
        for(int i = 0; i < n; i++) {
            int er = nums[i];
            int el = nums[n - i - 1];
            
            while(!stackRB.isEmpty() && nums[stackRB.peek()] > er) {
                rb[stackRB.pop()] = i;
            }
            
            while(!stackLB.isEmpty() && nums[stackLB.peek()] > el) {
                lb[stackLB.pop()] = n - i - 1;
            }
            
            stackRB.push(i);
            stackLB.push(n - i - 1);
        }
        
        for(int i = 0; i < n; i++) {
            int ilb = lb[i];
            int irb = rb[i];
            
            int in = irb - ilb - 1;
            
            if (in == 0) continue;
            
            double t = threshold / (double)in;
            
            if (t < (double)nums[i]) return in;
        }
        
        return -1;
    }
}