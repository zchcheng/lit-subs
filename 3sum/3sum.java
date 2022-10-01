class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Set<Integer> seen1 = new HashSet<>();
        
        for(int i = 0; i < nums.length - 2; i++) {
            int n = nums[i];
            
            if (seen1.contains(n)) continue;
            
            Set<Integer> seen = new HashSet<>();
            for(int j = i + 1; j < nums.length; j++) {
                if (seen.contains(-n - nums[j])) {
                    List<Integer> triple = Arrays.asList(n, nums[j], - n - nums[j]);
                    Collections.sort(triple);
                    result.add(triple);
                }
                seen.add(nums[j]);
            }
            
            seen1.add(n);
        }
        
        return new ArrayList<>(result);
    }
}