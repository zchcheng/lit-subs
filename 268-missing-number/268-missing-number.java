class Solution {
    public int missingNumber(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int k = Math.abs(nums[i]);
            if (k == nums.length + 1) {
                nums[0] = -Math.abs(nums[0]);
                continue;
            }
            if (k == nums.length) continue;
            if (nums[k] == 0) nums[k] = -(nums.length + 1);
            else nums[k] = -(Math.abs(nums[k]));
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) return i;
        }
        
        return nums.length;
    }
}