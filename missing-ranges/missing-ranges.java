class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int prev = lower - 1;
        
        for(int n : nums) {
            if (n < lower) continue;
            if (n > upper) break;
            
            if (n - 1 >= prev + 1) res.add(toString(prev + 1, n - 1));
            prev = n;
        }
        if (upper >= prev + 1) res.add(toString(prev + 1, upper));
        
        return res;
    }
    
    String toString(int s, int e) {
        if (s == e) return s + "";
        return s + "->" + e;
    }
}