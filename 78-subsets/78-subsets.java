class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result, new LinkedList<>());
        return result;
    }
    
    void helper(int[] nums, int n, List<List<Integer>> result, Deque<Integer> stack) {
        if (n == nums.length) {
            result.add(List.copyOf(stack));
            return;
        }
        
        stack.push(nums[n]);
        helper(nums, n + 1, result, stack);
        stack.pop();
        helper(nums, n + 1, result, stack);
    }
}