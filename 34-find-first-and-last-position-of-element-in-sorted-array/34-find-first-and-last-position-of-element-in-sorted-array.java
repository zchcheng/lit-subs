class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lb1 = lowerBound(nums, target);
        int lb2 = lowerBound(nums, target + 1) - 1;
        
        if (lb1 >= 0 && lb1 < nums.length && nums[lb1] == target && lb1 <= lb2) return new int[] {lb1, lb2};
        else return new int[] {-1, -1};
    }
    
    int lowerBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        
        while(l <= r) {
            int m = l + (r - l) / 2;
            
            int v = nums[m];
            
            if (v >= target) r = m - 1;
            else l = m + 1;
        }
        
        return l;
    }
}