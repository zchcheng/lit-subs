class Solution {
    int[] nums;
    
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        quickSelect(0, nums.length - 1, k - 1);
        return nums[k - 1];
    }
    
    int partition(int start, int end) {
        int pivot = nums[start];
        int j = start + 1;
        for(int i = start + 1; i <= end; i++) {
            int n = nums[i];
            if (n >= pivot) { swap(i, j++); }
        }
        swap(start, j - 1);
        return j - 1;
    }
    
    void quickSelect(int start, int end, int k) {
        int p = partition(start, end);
        
        if (p == k) return;
        
        if (p < k) {
            quickSelect(p + 1, end, k);
        } else {
            quickSelect(start, p - 1, k);
        }
    }
    
    void swap(int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}