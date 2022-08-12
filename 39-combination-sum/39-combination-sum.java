class Solution {
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(target, candidates, 0, new LinkedList<>());
        return res;
    }
    
    void helper(int target, int[] candidates, int start, LinkedList<Integer> current) {
        if (target == 0) {
            res.add(List.copyOf(current));
            return;
        }
        if (target < 0) return;
        if (start >= candidates.length) return;
        
        for(int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            helper(target - candidates[i], candidates, i, current);
            current.removeLast();
        }
    }
}