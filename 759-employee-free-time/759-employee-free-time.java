/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allIntervals = new ArrayList<>();
        
        for(List<Interval> intvs : schedule) {
            allIntervals.addAll(intvs);
        }
        
        allIntervals.sort((a, b) -> a.start - b.start);
        
        List<Interval> result = new ArrayList<>();
        
        Interval current = allIntervals.get(0);
        
        for(int i = 1; i < allIntervals.size(); i++) {
            Interval itv = allIntervals.get(i);
            
            if (current.end < itv.start) {
                result.add(new Interval(
                    current.end,
                    itv.start
                ));
            }
            
            if (itv.end >= current.end) {
                current = itv;
            }
        }
        
        return result;
    }
}