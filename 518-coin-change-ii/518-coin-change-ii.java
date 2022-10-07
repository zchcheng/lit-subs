class Solution {
    Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
    
    public int change(int amount, int[] coins) {
        return helper(amount, coins.length - 1, coins);
    }
    
    int helper(int amount, int n, int[] coins) {
        if (n == -1 && amount != 0) return 0;
        if (amount == 0) return 1;
        
        Integer result = memo.getOrDefault(n, new HashMap<>()).get(amount);
        
        if (result != null) return result;
        
        if (amount >= coins[n]) {
            result = helper(amount - coins[n], n, coins) + helper(amount, n - 1, coins);
        } else {
            result = helper(amount, n - 1, coins);
        }
        
        memo.computeIfAbsent(n, k -> new HashMap<>()).put(amount, result);
        
        return result;
    }
}