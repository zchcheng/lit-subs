class Solution {
    public int minCost(String colors, int[] neededTime) {
        int res = 0;
        
        for(int i = 1, mc = 0, sc = 0; i <= colors.length(); i++) {
            char c = (i == colors.length())? '-' : colors.charAt(i);
            char pc = colors.charAt(i - 1);
            
            if (c != pc) {
                res += (sc - mc);
                sc = 0;
                mc = 0;
                continue;
            }
            
            if (sc == 0) {
                mc = neededTime[i - 1];
                sc = mc;
            }
            
            mc = Math.max(mc, neededTime[i]);
            sc += neededTime[i];
        }
        
        return res;
    }
}