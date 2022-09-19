class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int minSteps(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        int R = forest.size(), C = forest.get(0).size();
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
            (a, b) -> Integer.compare(a[0], b[0]));
        heap.offer(new int[]{0, 0, sr, sc});

        HashMap<Integer, Integer> cost = new HashMap();
        cost.put(sr * C + sc, 0);

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int g = cur[1], r = cur[2], c = cur[3];
            if (r == tr && c == tc) return g;
            for (int di = 0; di < 4; ++di) {
                int nr = r + dr[di], nc = c + dc[di];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && forest.get(nr).get(nc) > 0) {
                    int ncost = g + 1 + Math.abs(nr-tr) + Math.abs(nc-tr);
                    if (ncost < cost.getOrDefault(nr * C + nc, 9999)) {
                        cost.put(nr * C + nc, ncost);
                        heap.offer(new int[]{ncost, g+1, nr, nc});
                    }
                }
            }
        }
        return -1;
    }

    public int cutOffTree(List<List<Integer>> forest) {
        List<int[]> trees = new ArrayList<>();
        
        for(int i = 0; i < forest.size(); ++i) {
            for(int j = 0; j < forest.get(0).size(); ++j) {
                int h = forest.get(i).get(j);
                if (h > 1) trees.add(new int[] { h, i, j });
            }
        }
        
        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));
        
        int result = 0;
        
        int sr = 0, sc = 0;
        for(int[] current: trees) {
            int step = minSteps(forest, sr, sc, current[1], current[2]);
            
            if (step < 0) return -1;
            
            result += step;
            
            sr = current[1];
            sc = current[2];
        }
        
        return result;
    }
}