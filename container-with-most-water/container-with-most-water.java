class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int lp = 0, rp = height.length - 1;
        
        while(lp < rp) {
            int vol = Math.min(height[lp], height[rp]) * (rp - lp);
            result = Math.max(vol, result);
            if (height[lp] > height[rp]) rp--;
            else lp++;
        }
        
        return result;
    }
}