class Solution {
    public long minimumHealth(int[] damage, int armor) {
        long res = 1;
        int max = 0;
        
        for(int d : damage) {
            res += d;
            max = Math.max(max, d);
        }
        
        res -= Math.min(max, armor);
        
        return res;
    }
}