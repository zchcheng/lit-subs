class Solution {
    public long kSum(int[] nums, int k) {
        long result = 0;
        
        for(int i = 0; i < nums.length; i++) {
            result += Math.max(0, nums[i]);
            nums[i] = Math.abs(nums[i]);
        }
        
        Arrays.sort(nums);
        
        PriorityQueue<long[]> heap = new PriorityQueue<long[]>((a, b) -> (int)(b[0] - a[0]));
        
        heap.offer(new long[] {result - nums[0], 0 });
        
        while(--k > 0) {
            long[] p = heap.poll();
            result = p[0];
            
            if (p[1] < nums.length - 1) {
                heap.offer(new long[] { result + nums[(int)p[1]] - nums[(int)p[1] + 1], (long)(p[1] + 1)});
                heap.offer(new long[] { result - nums[(int)p[1] + 1], (long)(p[1] + 1)});
            }
        }
        
        return result;
    }
}