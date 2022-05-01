class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        for(int i = 0, sum = 0; i < nums.length; i++) {
            sum += nums[i];
            int r = sum % k;
            Integer j = map.get(r);
            
            if (j != null && i - j >= 2) { System.out.println(i); System.out.println(j); return true; }
            
            if (!map.containsKey(r)) map.put(r, i);
        }
        
        return false;
    }
}