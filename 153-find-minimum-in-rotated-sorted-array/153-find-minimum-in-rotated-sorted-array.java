class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        
        while(l < r) {
            int m = l + (r - l) / 2;
            int n = nums[m];
            
            //if (nums[l] < nums[r]) return nums[l];
            
            if (n < nums[r]) r = m;
            else l = m + 1;
        }
        
        return nums[l];
    }
}