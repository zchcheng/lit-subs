class Solution {
    public int findMaxLength(int[] nums) {
        int res = 0, balance = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(balance, -1);
        
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            balance += (n == 0)? -1 : 1;
            if (!map.containsKey(balance)) map.put(balance, i);
            res = Math.max(res, i - map.get(balance));
        }
        
        return res;
    }
}