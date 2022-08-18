class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[nums[nums[0]]];
        int slow = nums[nums[0]];
        
        while(fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        
        fast = nums[0];
        
        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        
        return slow;
    }
}