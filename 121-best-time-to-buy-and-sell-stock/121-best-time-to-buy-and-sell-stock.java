class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int currentPrice = Integer.MAX_VALUE;
        
        for(int p : prices) {
            result = Math.max(p - currentPrice, result);
            currentPrice = Math.min(currentPrice, p);
        }
        
        return result;
    }
}