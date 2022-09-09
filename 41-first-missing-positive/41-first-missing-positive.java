class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MAX_VALUE) nums[i] = -1;
        }
        
        for(int i = 0; i < nums.length; i++) {
            helper(nums, nums[i]);
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) return i + 1;
        }
        
        return nums.length + 1;
    }
    
    void helper(int[] arr, int n) {
        if (n <= 0) return;
        if (n > arr.length) return;
        
        if (arr[n - 1] == 0) {
            arr[n - 1] = Integer.MAX_VALUE;
            return;
        }
        
        if (arr[n - 1] != Integer.MAX_VALUE) {
            int v = arr[n - 1];
            arr[n - 1] = Integer.MAX_VALUE;
            helper(arr, v);
        }
    }
}