class Solution {
    public int[][] merge(int[][] intervals) {
        // [1,3], [2,4], [5,6]
        // [5,6]
        
        List<int[]> result = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        int[] current = intervals[0];
        
        for(int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
                continue;
            }
            
            result.add(current);
            current = intervals[i];
        }
        
        result.add(current);
        
        int[][] res = new int[result.size()][2];
        
        for(int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        
        return res;
    }
}