class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        helper(nums, new LinkedList<>(), new HashSet<>());
        return result;
    }
    
    void helper(int[] nums, LinkedList<Integer> current, Set<Integer> visited) {
        if (visited.size() == nums.length) {
            result.add(List.copyOf(current));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (visited.contains(i)) continue;
            
            visited.add(i);
            current.add(nums[i]);
            helper(nums, current, visited);
            current.removeLast();
            visited.remove(i);
        }
    }
}