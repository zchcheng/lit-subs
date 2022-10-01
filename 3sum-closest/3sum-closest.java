class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        Integer result = null;
        
        for(int i = 0; i < nums.length - 2; i++) {
            int n = nums[i];
            
            for(int l = i + 1, r = nums.length - 1; l < r;) {
                int sum = n + nums[l] + nums[r];
                
                if (result == null || Math.abs(result - target) > Math.abs(sum - target)) result = sum;
                if (sum == target) return result;
                
                if (sum < target) l++;
                else r--;
            }
        }
        
        return result;
    }
}