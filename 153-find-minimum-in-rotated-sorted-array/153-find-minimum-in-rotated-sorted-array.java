class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        
        while(nums[l] > nums[r]) {
            int m = l + (r - l) / 2;
            
            if (nums[l] <= nums[m]) l = m + 1;
            else r = m;
        }
        
        return nums[l];
    }
}