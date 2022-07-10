class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int res = 0;
        int[] dp = new int[startTime.length];
        
        List<Entry> list = new ArrayList<>();
        
        for(int i = 0; i < startTime.length; i++) {
            list.add(new Entry(startTime[i], endTime[i], profit[i]));
        }
        
        list.sort((a, b) -> a.endTime - b.endTime);
        
        for(int i = 0; i < startTime.length; i++) {
            Entry entry = list.get(i);
            int prev = binSearch(list, entry.startTime);
            int vp = (prev == -1)? 0 : dp[prev];
            
            dp[i] = Math.max(vp + entry.profit, ((i == 0)? 0 : dp[i - 1]));
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
    
    private int binSearch(List<Entry> list, int target) {
        int s = 0;
        int e = list.size() - 1;
        
        while(s <= e) {
            int m = (s + e) / 2;
            
            Entry entry = list.get(m);
            
            if (entry.endTime <= target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        
        return e;
    }
    
    private class Entry {
        public int startTime;
        public int endTime;
        public int profit;
        
        public Entry(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }
    }
}