class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int current = 0;
        
        for(int n : nums) {
            int sum = current + n;
            result = Math.max(result, sum);
            current = Math.max(sum, 0);
        }
        
        return result;
    }
}