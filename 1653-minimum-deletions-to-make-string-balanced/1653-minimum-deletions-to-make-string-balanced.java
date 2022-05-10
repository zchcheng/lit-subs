class Solution {
    public int minimumDeletions(String s) {
        int na = 0;
        
        char[] arr = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++) {
            na += (arr[i] == 'a')? 1 : 0;
        }
        
        int res = na;
        
        for(int i = 0, a = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 'a') a++;
            
            // # of removal = (i + 1 - a) + (na - a);
            // = (# of removal of el before i (inclusive) that is not 'a') + (# of removal of el after i that is not 'b')
            res = Math.min(res, (i + na + 1 - 2*a));
        }
        
        return res;
    }
}