class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sumOfNums = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sumOfNums += nums[i];
        }
        
        long min = Long.MAX_VALUE;
        int minIdx = -1;
        
        long currentSum = 0;
        for(int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            long avgFirst = currentSum / (i + 1);
            long avgSecond = (i == nums.length - 1)? 0 : (sumOfNums - currentSum) / (nums.length - i - 1);
            
            long diff = Math.abs(avgFirst - avgSecond);
            
            if (diff < min) {
                minIdx = i;
                min = diff;
            }
        }
        
        return minIdx;
    }
}