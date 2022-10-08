class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = 1, r = Integer.MAX_VALUE;
        
        while(l <= r) {
            int m = (l + r) / 2;
            if (canDo(weights, m, days)) r = m - 1;
            else l = m + 1;
        }
        
        return l;
    }
    
    boolean canDo(int[] weights, int w, int days) {
        int d = 1;
        int sum = 0;
        
        for(int i = 0; i < weights.length; i++) {
            if (weights[i] > w) return false;
            
            if (sum + weights[i] > w) {
                d++;
                sum = weights[i];
                continue;
            }
            sum += weights[i];
        }
        
        return d <= days;
    }
}