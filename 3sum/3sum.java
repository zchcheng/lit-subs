class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            
            int target = -nums[i];
            
            int left = i + 1;
            int right = nums.length - 1;
            
            while(left < right) {
                int sum = nums[left] + nums[right];
                int l = nums[left];
                int r = nums[right];
                
                if (l + r == target) result.add(List.of(nums[i], l, r)); 
                if (l + r <= target) while(left < right && nums[++left] == l);
                if (l + r >= target) while(left < right && nums[--right] == r);
            }
        }
        
        return result;
    }
}