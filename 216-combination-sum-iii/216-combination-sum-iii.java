class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        
        helper(n, k, 1, new LinkedList<>(), result);
        
        return result;
    }
    
    void helper(int n, int k, int min, LinkedList<Integer> current, List<List<Integer>> result)  {
        if (n == 0 && k == 0) {
            result.add(List.copyOf(current));
            return;
        }
        
        if (n == 0 || k == 0 || min == 10) return;
        
        current.add(min);
        
        helper(n - min, k - 1, min + 1, current, result);
        
        current.removeLast();
        
        helper(n, k, min + 1, current, result);
    }
}