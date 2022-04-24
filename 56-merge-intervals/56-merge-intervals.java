class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) return intervals;
         
        List<int[]> merged = new ArrayList<>();
        
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });
        
        int[] current = intervals[0];
        
        for(int i = 1; i <= intervals.length; i++) {
            int[] next = (i < intervals.length)? intervals[i] : new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
            
            if (next[0] > current[1]) {
                merged.add(current);
                current = next;
                continue;
            }
            
            current[1] = Math.max(current[1], next[1]);
        }
        
        return merged.stream().toArray(int[][]::new);
    }
}