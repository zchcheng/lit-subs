class Solution {
    public int countServers(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        
        int[] rc = new int[r];
        int[] cc = new int[c];
        
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if (grid[i][j] == 0) continue;
                rc[i]++;
                cc[j]++;
                list.add(new Pair(i, j));
            }
        }
        
        int res = 0;
        
        for(Pair<Integer, Integer> p : list) {
            if (rc[p.getKey()] > 1 || cc[p.getValue()] > 1) res++;
        }
        
        return res;
    }
}