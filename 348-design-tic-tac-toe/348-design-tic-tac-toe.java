class TicTacToe {
    int sz = 0;
    Set<Pair<Integer, Integer>> m1 = new HashSet<>();
    Set<Pair<Integer, Integer>> m2 = new HashSet<>();

    public TicTacToe(int n) {
        sz = n;
    }
    
    public int move(int row, int col, int player) {
        return win(((player == 1)? m1 : m2), row, col, player);
    }
    
    int win(Set<Pair<Integer, Integer>> s, int r, int c, int p) {
        s.add(new Pair(r, c));
        return (checkVertical(s, r, c) || checkHorizontal(s, r, c) || checkDiagnol(s, r, c))? p : 0;
    }
    
    boolean checkVertical(Set<Pair<Integer, Integer>> s, int r, int c) {
        for(int i = 0; i < sz; i++) if (!s.contains(new Pair(i, c))) return false;
        return true;
    }
    
    boolean checkHorizontal(Set<Pair<Integer, Integer>> s, int r, int c) {
        for(int i = 0; i < sz; i++) if (!s.contains(new Pair(r, i))) return false;
        return true;
    }
    
    boolean checkDiagnol(Set<Pair<Integer, Integer>> s, int r, int c) {
        if (r != c && r + c != sz - 1) return false;
        
        boolean res1 = false;
        boolean res2 = false;
        
        if (r == c) {
            res1 = true;
            
            for(int i = 0; i < sz; i++) {
                if (!s.contains(new Pair(i, i))) {
                    res1 = false;
                    break;
                }
            }
        }
        
        if (r + c == sz - 1) {
            res2 = true;
            
            for(int i = 0; i < sz; i++) {
                if (!s.contains(new Pair(i, sz - i - 1))) {
                    res2 = false;
                    break;
                }
            }
        }
        
        return res1 || res2;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */