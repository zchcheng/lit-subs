class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        
        stack.push(new Pair(0, -1));
        
        for(int i = 0; i < heights.length; i++) {
            int h = heights[i];
            
            while(!stack.isEmpty() && stack.peek().getKey() > h) {
                Pair<Integer, Integer> p = stack.pop();
                int w = i - stack.peek().getValue() - 1;
                res = Math.max(res, w * p.getKey());
            }
            
            stack.push(new Pair(h, i));
        }
        
        while(!stack.isEmpty() && stack.peek().getKey() != 0) {
            Pair<Integer, Integer> p = stack.pop();
            int w = heights.length - stack.peek().getValue() - 1;
            res = Math.max(res, w * p.getKey());
        }
        
        return res;
    }
}