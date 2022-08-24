class Solution {
    public boolean canJump(int[] nums) {
        int reachIdx = 0;
        
        for(int i = 0; i < nums.length && reachIdx >= i; i++) {
            reachIdx = Math.max(reachIdx, i + nums[i]);
            if (reachIdx == nums.length - 1) return true;
        }
        
        return reachIdx >= nums.length - 1;
    }
}