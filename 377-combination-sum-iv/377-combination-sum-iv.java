class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return helper(nums, target, new HashMap<>());
    }
    
    int helper(int[] nums, int target, Map<Integer, Integer> memo) {
        if (target == 0) return 1;
        
        if (memo.containsKey(target)) return memo.get(target);
        
        int res = 0;
        
        for(int n : nums) {
            if (n > target) break;
            res += helper(nums, target - n, memo);
        }
        
        memo.put(target, res);
        
        return res;
    }
}