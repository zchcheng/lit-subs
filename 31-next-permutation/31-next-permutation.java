class Solution {
    public void nextPermutation(int[] nums) {
        int p = nums[nums.length - 1];
        int i = nums.length - 2;
        while(i >= 0) {
            if (nums[i] < nums[i + 1]) break;
            i--;
        }
        
        if (i == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        int j = nums.length - 1;
        while(nums[j] <= nums[i]) j--;
        
        swap(nums, i, j);
        reverse(nums, i + 1, nums.length - 1);
    }
    
    void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    
    void reverse(int[] nums, int s, int e) {
        while(s < e) {
            swap(nums, s++, e--);
        }
    }
}