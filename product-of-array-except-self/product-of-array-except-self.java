class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        
        for(int i = 1, prod = nums[0]; i < nums.length; i++) {
            result[i] = prod;
            prod *= nums[i];
        }
        
        for(int i = nums.length - 2, prod = nums[nums.length - 1]; i >= 0; i--) {
            result[i] = prod * result[i];
            prod *= nums[i];
        }
        
        return result;
    }
}