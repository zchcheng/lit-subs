object Solution {
    def canAttendMeetings(intervals: Array[Array[Int]]): Boolean = {
        var res = true
        val sorted = intervals.sortWith(_(0) <= _(0))
        
        for(i <- 1 to intervals.length - 1) {
            res &&= sorted(i)(0) >= sorted(i - 1)(1)
        }
        
        res
    }
}