class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        long[][] dist = new long[2][n];
        
        Arrays.fill(dist[0], Integer.MAX_VALUE);
        Arrays.fill(dist[1], Integer.MAX_VALUE);
        dist[0][src] = 0;
        dist[1][src] = 0;
        
        for(int i = 0; i <= k; i++) {
            for(int[] f : flights) {
                int s = f[0];
                int d = f[1];
                int w = f[2];
                
                dist[i % 2][d] = Math.min(dist[i % 2][d], dist[1 - i % 2][s] + w);
            }
        }
        
        return (int)(dist[k % 2][dst] == Integer.MAX_VALUE? -1 : dist[k % 2][dst]);
    }
}