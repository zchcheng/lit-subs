class Solution {
    public double angleClock(int hour, int minutes) {
        hour %= 12;
        minutes %= 60;
        
        double angMin = (double) minutes * 6;
        double angHour = (double) hour * 30 + (double)minutes * 0.5;
        
        double deg = Math.max(angHour, angMin) - Math.min(angHour, angMin);
        return Math.min(deg,  360 - deg);
    }
}