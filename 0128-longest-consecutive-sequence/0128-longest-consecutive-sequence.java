class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums) {
            set.add(n);
        }
        
        int res = 0;
        for(int i : set) {
            if (set.contains(i - 1)) continue;
            int j = i;
            while(set.contains(j)) {
                j += 1;
            }
            
            res = Math.max(res, j - i);
        }
        
        return res;
    }
}