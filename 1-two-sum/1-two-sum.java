class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexOfNums = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            Integer indexOfPair = indexOfNums.get(target - n);
            if (indexOfPair != null) return new int[] {i, indexOfPair};
            indexOfNums.put(n, i);
        }
        
        return null;
    }
}