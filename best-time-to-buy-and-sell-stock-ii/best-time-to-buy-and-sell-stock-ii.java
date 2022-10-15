class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        
        int current = Integer.MAX_VALUE;
        for(int p : prices) {
            current = Math.min(p, current);
            if (p > current) {
                result += p - current;
                current = p;
            }
        }
        
        return result;
    }
}