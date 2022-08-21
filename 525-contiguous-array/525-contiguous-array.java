class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        map.put(0, -1);
        
        for(int i = 0, cur = 0; i < nums.length; i++) {
            if (nums[i] == 0) cur--;
            else cur++;
            
            if (map.containsKey(cur)) {
                res = Math.max(res, i - map.get(cur));
            } else {
                map.put(cur, i);
            }
        }
        
        return res;
    }
}