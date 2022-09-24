class Solution {
    public int maxSubArray(int[] nums) {
        // [1, -2, 3, -1, 2, -2, 1]
        // sum: 3
        // result: 4
        // 
        
        int sum = 0;
        int result = Integer.MIN_VALUE;
        
        for(int n : nums) {
            sum += n;
            result = Math.max(result, sum);
            if (sum < 0) sum = 0;
        }
        
        return result;
    }
}