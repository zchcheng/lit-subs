class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        
        for(int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            int dif = sum - k;
            
            if (dif == 0) res++;
            res += map.getOrDefault(dif, 0);
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
}