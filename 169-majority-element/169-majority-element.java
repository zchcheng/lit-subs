class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        Integer current = null;
        
        for(int i = 0; i < nums.length; i++) {
            if (current == null) {
                current = nums[i];
                cnt = 1;
                continue;
            }
            
            if (nums[i] == current) {
                cnt += 1;
                continue;
            }
            
            cnt -= 1;
            if (cnt == 0) {
                current = null;
            }
        }
        
        return current;
    }
}