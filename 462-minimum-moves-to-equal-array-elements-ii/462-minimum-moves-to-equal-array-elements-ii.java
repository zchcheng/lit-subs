class Solution {
    public int minMoves2(int[] nums) {
        if (nums.length < 2) return 0;
        
        Arrays.sort(nums);
        
        int[] med = new int[2];
        
        med[0] = (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2;
        med[1] = med[0] + 1;
        
        int[] res = new int[2];
        for(int n : nums) {
            res[0] += Math.abs(med[0] - n);
            res[1] += Math.abs(med[1] - n);
        }
        
        return Math.min(res[0], res[1]);
    }
}