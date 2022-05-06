class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            int s = nums[start];
            int m = nums[mid];
            int e = nums[end];
            
            if (s <= m) {
                if (s <= target && target < m) end = mid - 1;
                else start = mid + 1;
            } else {
                if (m < target && target <= e) start = mid + 1;
                else end = mid - 1;
            }
        }
        
        return -1;
    }
}