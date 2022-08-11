class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        int[] current = newInterval;
        
        for(int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            
            if (current == null) {
                result.add(interval);
                continue;
            }
            
            if (isOverlapping(interval, current)) {
                current[0] = Math.min(interval[0], current[0]);
                current[1] = Math.max(interval[1], current[1]);
                continue;
            }
            
            
            if (interval[1] < current[0]) {
                result.add(interval);
                continue;
            }
            
            result.add(current);
            current = null;
            result.add(interval);
        }

        if (current != null) {
            result.add(current);
        }
        
        return result.toArray(int[][]::new);
    }
    
    boolean isOverlapping(int[] interval1, int[] interval2) {
        return Math.max(interval1[0], interval2[0]) <= Math.min(interval1[1], interval2[1]);
    }
}