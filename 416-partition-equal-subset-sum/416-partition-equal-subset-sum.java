class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n: nums) {
            sum += n;
        }
        if (sum % 2 != 0) return false;
        int n = nums.length;
        int target = sum / 2;
        Boolean[][] memo = new Boolean[n + 1][target + 1];
        return helper(nums, 0, target, memo);
    }
    
    boolean helper(int[] nums, int n, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (target < 0 || n >= nums.length) return false;
        
        if (memo[n][target] != null) return memo[n][target];
        
        boolean ret = helper(nums, n + 1, target - nums[n], memo) || helper(nums, n + 1, target, memo);
        memo[n][target] = ret;
        return ret;
    }
}