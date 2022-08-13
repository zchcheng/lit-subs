class Solution {
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;
        while(i <= r) {
            if (nums[i] == 0) swap(nums, i++, l++);
            else if (nums[i] == 2) swap(nums, i, r--);
            else i++;
        }
    }
    
    void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}