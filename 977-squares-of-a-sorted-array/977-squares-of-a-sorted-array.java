class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        
        int l = 0;
        int r = nums.length - 1;
        int i = nums.length - 1;
        
        while (l <= r) {
            int a = nums[l] * nums[l];
            int b = nums[r] * nums[r];
            
            res[i] = (a >= b)? a : b;
            
            if (a == res[i]) l++;
            else r--;
            
            i--;
        }
        
        return res;
    }
}