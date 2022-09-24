class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    int[] coins = null;
    
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        return helper(amount);
    }
    
    int helper(int amount) {
        if (amount == 0)  return 0;
        
        if (memo.containsKey(amount)) return memo.get(amount);
        
        int res = -1;
        for(int coin : coins) {
            if (amount < coin) continue;
            
            int numOfCoinNeeded = helper(amount - coin);
            
            if (numOfCoinNeeded == -1) continue;
            
            if (res == -1 || res > numOfCoinNeeded + 1) res = numOfCoinNeeded + 1;
        }
        
        memo.put(amount, res);
        
        return res;
    }
}