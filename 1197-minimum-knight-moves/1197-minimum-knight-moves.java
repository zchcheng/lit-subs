class Solution {
    public int minKnightMoves(int x, int y) {
        return helper(new Loc(Math.abs(x), Math.abs(y)), new HashMap<>());
    }
    
    int helper(Loc loc, Map<Loc, Integer> memo) {
        if (loc.x == 0 && loc.y == 0) return 0;
        if (loc.x + loc.y == 2) return 2;
        if (memo.containsKey(loc)) return memo.get(loc);
        
        int res = Math.min(
            helper(new Loc(Math.abs(loc.x - 2), Math.abs(loc.y - 1)), memo),
            helper(new Loc(Math.abs(loc.x - 1), Math.abs(loc.y - 2)), memo)
        ) + 1;
        
        memo.put(loc, res);
        
        return res;
    }
    
    class Loc {
        int x;
        int y;
        
        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int hashCode() {
            return (x + "," + y).hashCode();
        }
        
        @Override
        public boolean equals(Object o) {
            return ((Loc)o).x == x && ((Loc)o).y == y;
        }
    }
}