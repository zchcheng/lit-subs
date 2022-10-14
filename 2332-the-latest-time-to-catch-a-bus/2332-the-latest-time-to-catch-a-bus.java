class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        
        int current = 0;
        int result = 0;
        
        int lastPassenger = 0;
        for(int bus : buses) {
            int cnt = 0;
            
            for(; cnt < capacity && current < passengers.length && passengers[current] <= bus; cnt++, current++);
            
            int pointer = current - 1;
            int possibleTime = (cnt == capacity)? passengers[pointer] : bus;
            
            while(cnt > 0 && passengers[pointer] == possibleTime) {
                possibleTime = passengers[pointer--] - 1;
                cnt--;
            }
            
            if (possibleTime > lastPassenger) result = possibleTime;
            if (current > 0) lastPassenger = passengers[current - 1];
        }
        
        return result;
    }
}