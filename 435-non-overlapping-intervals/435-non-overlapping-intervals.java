class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) return 0;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int cur = 0;
        int res = 0;
        
        for(int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[cur][1]) {
                res++;
                cur = (intervals[i][1] > intervals[cur][1])? cur : i;
            } else {
                cur = i;
            }
        }
        
        return res;
    }
}