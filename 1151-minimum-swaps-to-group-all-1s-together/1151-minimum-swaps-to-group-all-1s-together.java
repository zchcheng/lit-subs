class Solution {
    public int minSwaps(int[] data) {
        int s = 0;
        for(int i : data) s += i;
        
        int cur = 0;
        
        for(int i = 0; i < s; i++) {
            cur += data[i];
        }
        
        int res = s - cur;
        
        for(int i = 0; i + s < data.length; i++) {
            cur += data[i + s] - data[i];
            res = Math.min(res, s - cur);
        }
        
        return res;
    }
}