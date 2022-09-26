class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> - (a[0] * a[0] + a[1] * a[1]) + (b[0] * b[0] + b[1] * b[1]));
        
        for(int i = 0; i < points.length; i++) {
            int[] p = points[i];
            pq.offer(p);
            
            while(pq.size() > k) {
                pq.poll();
            }
        }
        
        int[][] result = new int[k][2];
        
        for(int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        
        return result;
    }
}