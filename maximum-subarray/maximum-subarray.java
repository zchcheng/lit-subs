class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int current = 0;
        
        for(int n : nums) {
            current += n;
            
            result = Math.max(result, current);
            
            if (current < 0) current = 0;
        }
        
        return result;
    }
}