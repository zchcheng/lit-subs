class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int current = Integer.MAX_VALUE;
        
        for(int p : prices) {
            current = Math.min(current, p);
            result = Math.max(result, p - current);
        }
        
        return result;
    }
}