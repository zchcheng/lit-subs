class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int res = 0;
        int total = 0;
        
        for(int i = 0, cur = 0; i < gas.length; i++) {
            int g = gas[i];
            int c = cost[i];
            int gain = g - c;
            cur += gain;
            total += gain;
            if (cur < 0) {
                cur = 0;
                res = i + 1;
            }
        }
        
        return (total >= 0)? res : -1;
    }
}