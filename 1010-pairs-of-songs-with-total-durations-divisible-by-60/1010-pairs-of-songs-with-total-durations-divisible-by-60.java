class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] rem = new int[60];
        int res = 0;
        
        for(int t : time) {
            res += rem[(60 - t % 60) % 60];
            rem[t % 60]++;
        }
        
        return res;
    }
}