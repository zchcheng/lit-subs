class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        int res = 0;
        
        for(int right = 0, left = -1; right < nums.length; right++) {
            int v = nums[right];
            while(!min.isEmpty() && min.peekFirst() > v) min.pop();
            while(!max.isEmpty() && max.peekFirst() < v) max.pop();
            min.push(v);
            max.push(v);
            
            while(left < right) {
                if (max.peekLast() - min.peekLast() <= limit)  break;
                left++;
                if (nums[left] == max.peekLast()) max.pollLast();
                if (nums[left] == min.peekLast()) min.pollLast();
            }
            
            res = Math.max(res, right - left);
        }
        
        return res;
    }
}