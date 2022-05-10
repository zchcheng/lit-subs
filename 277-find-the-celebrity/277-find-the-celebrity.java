/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int res = 0;
        
        for(int i = 0; i < n; i++) {
            if (res == i) {
                continue;
            }
            
            if (knows(res, i)) { 
                // res knows someone else, so s/he cannot be the celebrity
                // the next possible one would be i since someone knows him/her.
                res = i;
            }
        }
        
        for(int i = 0; i < n; i++) {
            if (res == i) continue;
            if (!knows(i, res)) {
                return -1;
            }
            
            if (knows(res, i)) {
                return -1;
            }
        }
        
        return res;
    }
}