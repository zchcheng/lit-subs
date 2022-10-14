class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        
        int pi = 0;
        int result = 0;
        
        int pb = 0;
        for(int b : buses) {
            int cnt = 0;
            
            for(; cnt < capacity && pi < passengers.length && passengers[pi] <= b; cnt++, pi++);
            
            int tpi = pi - 1;
            int tmp = (cnt == capacity)? passengers[tpi] : b;
            
            int npb = pb;
            while(cnt > 0 && passengers[tpi] == tmp) {
                npb = Math.max(npb, passengers[tpi]);
                tmp = passengers[tpi--] - 1;
                cnt--;
            }
            
            if (tmp > pb) result = tmp;
            pb = npb;
        }
        
        return result;
    }
}