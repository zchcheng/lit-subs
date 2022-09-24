class Solution {
    public int maxProfit(int[] prices) {
        int stockMinPrice = Integer.MAX_VALUE;
        int profit = 0;
        
        for(int p : prices) {
            profit = Math.max(profit, p - stockMinPrice);
            stockMinPrice = Math.min(stockMinPrice, p);
        }
        
        return profit;
    }
}