class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] occurence = new int[26];
        for(char t : tasks) occurence[t - 'A']++;
        Arrays.sort(occurence);
        
        int idle = (occurence[25] - 1) * n;
        
        int i = 24;
        while(idle > 0 && i >= 0) {
            idle -= Math.min(occurence[25] - 1, occurence[i--]);
        }
        
        idle = Math.max(0, idle);
        
        return tasks.length + idle;
    }
}