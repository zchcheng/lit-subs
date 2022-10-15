class Solution {
    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        
        k = k % nums.length;
        
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    void reverse(int[] arr, int s, int e) {
        while(s < e) {
            swap(arr, s, e);
            s++; e--;
        }
    }
    
    void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}