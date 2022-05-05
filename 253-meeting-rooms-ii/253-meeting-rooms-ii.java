class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int res = 0;
        
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int[] i : intervals) {
            while(!pq.isEmpty() && pq.peek() <= i[0]) {
                pq.poll();
            }
            
            pq.offer(i[1]);
            
            res = Math.max(res, pq.size());
        }
        
        return res;
    }
}