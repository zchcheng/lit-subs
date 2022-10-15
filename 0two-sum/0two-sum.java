class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexOfNum = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            
            if (indexOfNum.containsKey(target - n)) return new int[] {i, indexOfNum.get(target - n)};
            
            indexOfNum.put(n, i);
        }
        
        return null;
    }
}