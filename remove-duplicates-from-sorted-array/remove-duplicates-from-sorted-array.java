class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                swap(nums, i, ++j);
            }
        }
        return j + 1;
    }
    
    void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}