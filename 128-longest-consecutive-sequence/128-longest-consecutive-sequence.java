class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums) {
            set.add(n);
        }
        
        for(int n : nums) {
            if (set.contains(n - 1)) continue;
            
            int con = 1, cur = n;
            
            while(set.contains(cur + 1)) {
                con++;
                cur++;
            }
            
            res = Math.max(res, con);
        }
        
        return res;
    }
}