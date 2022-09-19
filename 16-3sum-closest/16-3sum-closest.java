class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Integer result = null;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == target) return target;
                
                if (result == null || Math.abs(result - target) > Math.abs(sum - target)) {
                    result = sum;
                } 
                
                if (sum > target) { right--; } 
                else { left++; }
            }
        }
        
        return result;
    }
}