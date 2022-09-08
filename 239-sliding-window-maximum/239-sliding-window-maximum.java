class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        
        for(int i = 0; i < k; i++) {
            int n = nums[i];
            
            while(!deque.isEmpty() && deque.peek() < n) {
                deque.pop();
            }
            
            deque.push(n);
        }
        
        int[] res = new int[nums.length - k + 1];
        
        for(int i = k; i < nums.length; i++) {
            res[i - k] = deque.peekLast();
            
            if (nums[i - k] == deque.peekLast()) deque.removeLast();
            
            while(!deque.isEmpty() && deque.peek() < nums[i]) {
                deque.pop();
            }
            
            deque.push(nums[i]);
        }
        
        res[nums.length - k] = deque.peekLast();
        
        return res;
    }
}