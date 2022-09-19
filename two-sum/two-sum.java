class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexOfElement = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (indexOfElement.containsKey(diff)) {
                return new int[] {i, indexOfElement.get(diff)};
            }
            indexOfElement.put(nums[i], i);
        }
        
        return null;
    }
}