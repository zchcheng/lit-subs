class Solution {
    int n;
    
    public int snakesAndLadders(int[][] board) {
        n = board.length;
        Queue<Loc> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        q.offer(new Loc(1));
        
        int res = 0;
        
        while(!q.isEmpty()) {
            for(int i = q.size(); i > 0; i--) {
                Loc loc = q.poll();
                
                for(int j = 0; j < 6; j++) {
                    Loc next = loc.getNext(j + 1);
                    
                    if (board[next.r][next.c] != -1) {
                        next = new Loc(board[next.r][next.c]);
                    } 
                    
                    if (next.dest()) return res + 1;
                    
                    if (!visited.contains(next.x)) { 
                        visited.add(next.x); 
                        q.offer(next); 
                    }
                }
            }
            res++;
        }
        
        return -1;
    }
    
    class Loc {
        public int r;
        public int c;
        public int x;
        
        public Loc(int x) {
            r = n - ((x - 1) / n) - 1;
            c = (x - 1) % n;
            if ((n - r - 1) % 2 == 1) c = n - c - 1;
            this.x = x;
        }
        
        public boolean dest() {
            return x == n * n;
        }
        
        public Loc getNext(int i) {
            return new Loc(x + i);
        }
    }
}