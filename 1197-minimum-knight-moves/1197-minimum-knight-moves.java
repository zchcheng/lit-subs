class Solution {
    Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
    
    public int minKnightMoves(int x, int y) {
        return helper(x, y);
    }
    
    int helper(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        
        Pair<Integer, Integer> p = new Pair(x, y);
        
        if (map.containsKey(p)) return map.get(p);
        
        if (x == 0 && y == 0) return 0;
        
        if (x + y == 2) return 2;
        
        int res = Math.min(helper(x - 2, y - 1), helper(x - 1, y - 2)) + 1;
        
        map.put(p, res);
        
        return res;
    }
}