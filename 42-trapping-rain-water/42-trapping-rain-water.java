class Solution {
    public int trap(int[] height) {
        int res = 0;
        int l = 0;
        int r = height.length - 1;
        int ml = 0;
        int mr = 0;
        
        while(l < r) {
            if (height[l] < height[r]) {
                ml = Math.max(height[l], ml);
                res += ml - height[l];
                l++;
            }
            
            if (height[l] >= height[r]) {
                mr = Math.max(height[r], mr);
                res += mr - height[r];
                r--;
            }
        }
        
        return res;
    }
}