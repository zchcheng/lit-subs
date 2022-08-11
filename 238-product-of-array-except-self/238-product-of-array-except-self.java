class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        Arrays.fill(res, 1);
        
        for(int i = 0, cur = 1; i < nums.length; i++) {
            res[i] *= cur;
            cur *= nums[i];
        }
        
        for(int i = 0, cur = 1; i < nums.length; i++) {
            res[nums.length - 1 - i] *= cur;
            cur *= nums[nums.length - 1 - i];
        }
        
        return res;
    }
}