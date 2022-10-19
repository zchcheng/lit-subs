class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int prev = lower - 1;
        List<int[]> rs = new ArrayList<>();
        
        for(int n : nums) {
            if (n < lower) continue;
            if (n > upper) break;
            
            rs.add(new int[] {prev + 1, n - 1});
            prev = n;
        }
        
        rs.add(new int[] {prev + 1, upper});
        
        List<String> res = new ArrayList<>();
        for(int[] r : rs) {
            String str = toString(r);
            if (str != null) res.add(str);
        }
        
        return res;
    }
    
    String toString(int[] r) {
        if (r[0] > r[1]) return null;
        if (r[0] == r[1]) return r[0] + "";
        return r[0] + "->" + r[1];
    }
}