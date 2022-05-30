/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */

class Solution extends VersionControl {
    def firstBadVersion(n: Int): Int = {
        var s = 0
        var e = n
        
        while (s <= e) {
            val mid = s + (e - s) / 2
            if (isBadVersion(mid)) e = mid - 1
            else s = mid + 1
        }
        
        s
    }
}