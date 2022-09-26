class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, 0, nums.length - 1, k - 1);
        return nums[k - 1];
    }
    
    void quickSelect(int[] nums, int l, int r, int k) {
        int pidx = partition(nums, l, r);
        
        if (pidx == k) return;
        
        if (pidx < k) quickSelect(nums, pidx + 1, r, k);
        else quickSelect(nums, l, pidx - 1, k);
    }
    
    int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        
        int j = l + 1;
        
        for(int i = l + 1; i <= r; i++) {
            if (nums[i] >= pivot) swap(nums, i, j++);
        }
        
        swap(nums, l, j - 1);
        
        return j - 1;
    }
    
    void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}