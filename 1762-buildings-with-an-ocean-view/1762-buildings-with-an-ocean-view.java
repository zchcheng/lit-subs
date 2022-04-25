class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = heights.length - 1, max = 0; i >= 0; i--) {
            int h = heights[i];
            if (h <= max) continue;
            list.add(i);
            max = Math.max(max, h);
        }
        
        int[] res = new int[list.size()];
        
        int n = list.size();
        for(int i = n - 1; i >= 0; i--) {
            res[n - i - 1] = list.get(i);
        }
        
        return res;
    }
}