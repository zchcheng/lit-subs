class Solution {
    int n;
    
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        Queue<Loc> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        q.offer(new Loc(1));
        
        int turn = 0;
        while(!q.isEmpty()) {
            for(int i = q.size(); i > 0; i--) {
                Loc loc = q.poll();
                
                if (loc.dest()) return turn;
                
                for(int j = 0; j < 6; j++) {
                    loc.next();
                    Loc next = null;
                    
                    if (board[loc.r][loc.c] != -1) {
                        next = new Loc(board[loc.r][loc.c]);
                    } else {
                        next = new Loc(loc.x);
                    }
                    
                    if (next.dest()) return turn + 1;
                    
                    if (!visited.contains(next.x)) { visited.add(next.x); q.offer(next); }
                }
            }
            turn++;
        }
        
        return -1;
    }
    
    class Loc {
        public int r;
        public int c;
        public int x;
        
        public Loc(int x) {
            set(x);
        }
        
        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
            this.x = n * (n - r - 1);
            if ((n - r - 1) % 2 == 0) this.x += c + 1;
            else this.x += n - c;
        }
        
        public void next() {
            set(x + 1);
        }
        
        void set(int x) {
            r = n - ((x - 1) / n) - 1;
            c = (x - 1) % n;
            if ((n - r - 1) % 2 == 1) c = n - c - 1;
            this.x = x;
        }
        
        public boolean dest() {
            return x == n * n;
        }
        
        @Override
        public boolean equals(Object o) {
            Loc l = (Loc)o;
            return l.x == x;
        }
        
        @Override
        public int hashCode() {
            return x;
        }
    }
}