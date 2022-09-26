class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        // tc: nlogn
        Arrays.sort(nums);
        
        int min = 0;
        int max = nums[nums.length - 1] - nums[0];
        
        while(min < max) {
            int m = min + (max - min) / 2;
            
            int cnt = 0;
            
            for(int i = 1, j = 0; i < nums.length; i++) {
                while(nums[i] - nums[j] > m) j++;
                cnt += i - j;
                if (cnt > k - 1) break;
            }
            
            if (cnt > k - 1) max = m;
            else min = m + 1;
        }
        
        return max;
    }
}