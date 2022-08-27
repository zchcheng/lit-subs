class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }
    
    int quickSelect(int[] nums, int l, int r, int k) {
        int p = partition(nums, l, r);
        if (p == k) return nums[k];
        if (p > k) return quickSelect(nums, l, p - 1, k);
        return quickSelect(nums, p + 1, r, k);
    }
    
    int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i = l + 1;
        
        for(int j = l + 1; j <= r; j++) {
            if (nums[j] >= pivot) {
                swap(nums, j, i++);
            }
        }
        
        swap(nums, i - 1, l);
        return i - 1;
    }
    
    void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}