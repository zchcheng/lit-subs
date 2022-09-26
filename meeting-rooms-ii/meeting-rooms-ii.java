class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<Integer> startTime = new ArrayList<>();
        List<Integer> endTime = new ArrayList<>();
        
        for(int[] interval : intervals) {
            startTime.add(interval[0]);
            endTime.add(interval[1]);
        }
        
        Collections.sort(startTime);
        Collections.sort(endTime);
        
        int result = 0;
        
        for(int i = 0, j = -1; i < intervals.length; i++) {
            while(endTime.get(j + 1) <= startTime.get(i)) j++;
            result = Math.max(result, i - j);
        }
        
        return result;
    }
}