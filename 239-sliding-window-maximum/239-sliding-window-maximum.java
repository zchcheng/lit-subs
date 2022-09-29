class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            
            while(!deque.isEmpty() && nums[deque.peek()] <= n) {
                deque.pop();
            }
            
            deque.push(i);
            
            while(!deque.isEmpty() && deque.peekLast() <= i - k) deque.pollLast();
            
            if (i < k - 1) continue;
            
            result[i - k + 1] = nums[deque.peekLast()];
        }
        
        return result;
    }
}