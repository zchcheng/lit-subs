class Solution {
    int[] nums;
    
    public int findPeakElement(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length);
    }
    
    int helper(int start, int end) {
        int mid = (start + end) / 2;
        
        long v = nums[mid];
        
        long vl = (mid - 1 < 0)? Long.MIN_VALUE : nums[mid - 1];
        long vr = (mid + 1 >= nums.length)? Long.MIN_VALUE : nums[mid + 1];
        
        if (v > vl && v > vr) return mid;
        
        if (v <= vl) return helper(start, mid - 1);
        return helper(mid + 1, end);
    }
}