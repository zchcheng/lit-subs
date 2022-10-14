class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        
        int index = 0;
        int result = 0;
        
        int lastPassenger = 0;
        for(int bus : buses) {
            int cnt = 0;
            
            for(; cnt < capacity && index < passengers.length && passengers[index] <= bus; cnt++, index++);
            
            int pointer = index - 1;
            int possibleTime = (cnt == capacity)? passengers[pointer] : bus;
            
            while(cnt > 0 && passengers[pointer] == possibleTime) {
                possibleTime = passengers[pointer--] - 1;
                cnt--;
            }
            
            if (possibleTime > lastPassenger) result = possibleTime;
            if (index > 0) lastPassenger = passengers[index - 1];
        }
        
        return result;
    }
}