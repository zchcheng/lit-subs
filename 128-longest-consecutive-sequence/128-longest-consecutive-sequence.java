class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums) {
            set.add(n);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums) {
            if (map.containsKey(n)) continue;
            
            int cur = n, con = 1;
            while(set.contains(cur + 1)) {
                if (map.containsKey(cur + 1)) {
                    con += map.get(cur + 1);
                    break;
                }
                con++;
                cur++;
            }
            
            map.put(n, con);
            
            res = Math.max(res, con);
        }
        
        return res;
    }
}