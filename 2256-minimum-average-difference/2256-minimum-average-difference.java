class Solution {
    public int minimumAverageDifference(int[] nums) {
        long[] prefixSum = new long[nums.length];
        
        for(long i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[(int)i];
            prefixSum[(int)i] = sum;
        }
        
        long min = Long.MAX_VALUE;
        int minIdx = -1;
        
        for(int i = 0; i < nums.length; i++) {
            long avgFirst = prefixSum[i] / (i + 1);
            long avgSecond = (i == nums.length - 1)? 0 : (prefixSum[nums.length - 1] - prefixSum[i]) / (nums.length - i - 1);
            
            long diff = Math.abs(avgFirst - avgSecond);
            
            if (diff < min) {
                minIdx = i;
                min = diff;
            }
        }
        
        return minIdx;
    }
}