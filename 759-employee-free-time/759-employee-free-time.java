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
        List<Interval> result = List.of(new Interval(Integer.MIN_VALUE, Integer.MAX_VALUE));
        
        for(List<Interval> intervals : schedule) {
            List<Interval> next = new LinkedList<>();
            List<Interval> free = getFreeIntervals(intervals);
            
            for(int i = 0, j = 0; i < result.size() && j < free.size();) {
                Interval cmn = result.get(i);
                Interval emp = free.get(j);
                
                if (cmn.end <= emp.start) {
                    i++;
                    continue;
                }
                
                if (emp.end <= cmn.start) {
                    j++;
                    continue;
                }
                
                Interval ni = new Interval(
                    Math.max(cmn.start, emp.start),
                    Math.min(cmn.end, emp.end)
                );
                
                if (ni.start >= ni.end) continue;
                
                next.add(ni);
                
                if (cmn.end > emp.end) j++;
                else i++;
            }
                
            result = next;
        }
        
        List<Interval> finals = new LinkedList<>();
        
        for(Interval intv : result) {
            if (intv.start != Integer.MIN_VALUE && intv.end != Integer.MAX_VALUE) finals.add(intv);
        }
        
        return finals;
    }
    
    List<Interval> getFreeIntervals(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        
        result.add(new Interval(
            Integer.MIN_VALUE,
            intervals.get(0).start
        ));
        
        for(int i = 1; i < intervals.size(); i++) {
            Interval ni = new Interval(
                intervals.get(i - 1).end,
                intervals.get(i).start
            );
            if (ni.start >= ni.end) continue;
            result.add(ni);
        }
        
        result.add(new Interval(
            intervals.get(intervals.size() - 1).end,
            Integer.MAX_VALUE
        ));
            
        return result;
    }
}