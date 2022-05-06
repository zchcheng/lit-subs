class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] == target) {
                return start;
            }
            if (nums[end] == target) {
                return end;
            }
            
            int s = nums[start];
            int m = nums[mid];
            int e = nums[end];
            
            if (m < e) {
                if (m < target && target < e) start = mid + 1;
                else end = mid - 1;
            } else {
                if (s < target && target < m) end = mid - 1;
                else start = mid + 1;
            }
        }
        
        return -1;
    }
}