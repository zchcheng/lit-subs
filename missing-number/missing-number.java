class Solution {
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int ri = Math.abs(nums[i]);
            if (ri >= nums.length) continue;
            if (nums[ri] == 0) {
                nums[0] = -Math.abs(nums[0]);
                nums[ri] = -nums.length;
            }
            else nums[ri] = -Math.abs(nums[ri]);
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) continue;
            return i;
        }
        
        return nums.length;
    }
}