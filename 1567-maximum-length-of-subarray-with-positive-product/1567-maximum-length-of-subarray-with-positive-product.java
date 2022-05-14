class Solution {
    public int getMaxLen(int[] nums) {
        int in = nums.length;
        int inn = -1;
        int cntNeg = 0;
        int res = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v == 0) {
                in = nums.length;
                inn = i;
                cntNeg = 0;
            }
            
            if (v < 0) {
                in = Math.min(in, i);
                cntNeg++;
            } 
            
            res = Math.max(res, (cntNeg % 2 == 0)? i - inn : i - in);
        }
        
        return res;
    }
}