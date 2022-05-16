class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
            return a[1] - b[1];
        });
        
        int sum = 0;
        int cnt = 0;
        
        for(int i = 0; i < boxTypes.length; i++) {
            int[] b = boxTypes[i];
            pq.offer(b);
            sum += b[1] * b[0];
            cnt += b[0];
            
            while(cnt - pq.peek()[0] >= truckSize) {
                int[] r = pq.poll();
                sum -= r[1] * r[0];
                cnt -= r[0];
            }
            
            int d = Math.max(cnt - truckSize, 0);
            pq.peek()[0] -= d;
            cnt -= d;
            sum -= d * pq.peek()[1];
        }
        
        return sum;
    }
}