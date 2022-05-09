class Solution {
    public int orangesRotting(int[][] grid) {
        Set<Pair<Integer, Integer>> freshes = new HashSet<>();
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        
        int r = grid.length;
        int c = grid[0].length;
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    freshes.add(new Pair(i, j));
                }
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }
        
        int i = 0;
        for(;!queue.isEmpty() && !freshes.isEmpty(); i++) {
            
            for(int j = queue.size(); j > 0; j--) {
                Pair<Integer, Integer> p = queue.poll();
                
                for(int[] n : new int[][] { {0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
                    int nx = p.getKey() + n[0];
                    int ny = p.getValue() + n[1];
                    
                    Pair np = new Pair(nx, ny);
                    
                    if (!freshes.contains(np)) {
                        continue;
                    }
                    
                    queue.offer(np);
                    freshes.remove(np);
                }
            }
        }
        
        return (freshes.size() > 0)? -1 : i;
    }
}