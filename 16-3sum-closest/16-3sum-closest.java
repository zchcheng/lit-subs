class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int res = 0;
        int diff = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length - 2; i++) {
            int n = nums[i];
            
            int l = i + 1;
            int r = nums.length - 1;
            
            while(l < r) {
                int nl = nums[l];
                int nr = nums[r];
                
                int sum = nl + nr + n;
                
                if (diff > Math.abs(target - sum)) {
                    res = sum;
                    diff = Math.abs(target - sum);
                }
                
                if (sum == target) return res;
                if (sum < target) l++;
                else r--;
            }
        }
        
        return res;
    }
}