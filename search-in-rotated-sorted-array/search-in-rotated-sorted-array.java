class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        
        while(l <= r) {
            int m = l + (r - l) / 2;
            
            if (nums[l] == target) return l;
            if (nums[m] == target) return m;
            if (nums[r] == target) return r;
            
            if (nums[l] < nums[m] && nums[l] < target && target < nums[m]) r = m;
            else if (nums[l] > nums[m] && (target > nums[l] || target < nums[m])) r = m;
            else l = m + 1;
        }
        
        return -1;
    }
}