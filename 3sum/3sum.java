class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < nums.length - 2;) {
            int a = nums[i];
            
            for(int l = i + 1, r = nums.length - 1; l < r;) {
                int b = nums[l];
                int c = nums[r];
                
                int s = a + b + c;
                
                if (s == 0) {
                    res.add(List.of(a, b, c));
                    while(l < r && nums[++l] == b);
                    r--;
                } else if (s < 0) { l++; } 
                else { r--; }
            }
            
            while(i < nums.length - 2 && nums[++i] == a);
        }

        return res;
    }
}