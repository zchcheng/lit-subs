class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        
        for(int i = 0, j = 1; i < n; i++) {
            res[i] *= j;
            j *= nums[i];
        }
        
        for(int i = n - 1, j = 1; i >= 0; i--) {
            res[i] *= j;
            j *= nums[i];
        }
        
        return res;
    }
}