class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            return (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]) ;
        });
        
        for(int[] p : points) {
            pq.offer(p);
            
            while(pq.size() > k) {
                pq.poll();
            }
        }
        
        int[][] res = new int[k][0];
        
        for(int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        
        return res;
    }
}