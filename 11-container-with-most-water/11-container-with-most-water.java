class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        
        int l = 0;
        int r = height.length - 1;
        
        while(l < r) {
            res = Math.max(Math.min(height[l], height[r]) * (r - l), res);
            if (height[l] >= height[r]) r--;
            else l++;
        }
        
        return res;
    }
}