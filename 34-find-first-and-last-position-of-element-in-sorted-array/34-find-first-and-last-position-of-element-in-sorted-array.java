class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lb = upperBound(nums, target - 1);
        int ub = lowerBound(nums, target + 1);
        
        if (lb <= ub) return new int[] {lb, ub};
        return new int[] {-1, -1};
    }
    
    int upperBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        
        while(l <= r) {
            int m = l + (r - l) / 2;
            
            if (nums[m] > target) r = m - 1;
            else l = m + 1;
        }
        
        return l;
    }
    
    int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        
        while(l <= r) {
            int m = l + (r - l) / 2;
            
            if (nums[m] < target) l = m + 1;
            else r = m - 1;
        }
        
        return r;
    }
}