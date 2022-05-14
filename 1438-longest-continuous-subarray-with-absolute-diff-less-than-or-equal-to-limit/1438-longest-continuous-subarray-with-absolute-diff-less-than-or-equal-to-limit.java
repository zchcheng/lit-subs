class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<int[]> min = new PriorityQueue<>((int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        PriorityQueue<int[]> max = new PriorityQueue<>((int[] a, int[] b) -> {
            return b[0] - a[0];
        });
        
        int res = 0;
        
        for(int right = 0, left = -1; right < nums.length; right++) {
            int v = nums[right];
            int[] p = new int[] {v, right};
            
            min.offer(p);
            max.offer(p);
            
            while(left < right) {
                if (max.peek()[0] - min.peek()[0] <= limit)  {
                    break;
                }
                left++;
                while(max.peek()[1] <= left) max.poll();
                while(min.peek()[1] <= left) min.poll();
            }
            
            res = Math.max(res, right - left);
        }
        
        return res;
    }
}