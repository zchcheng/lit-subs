class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<Integer>(Arrays.stream(nums).boxed().toList());
        
        Set<Integer> visited = new HashSet<>();
        
        for(int n : nums) {
            if (visited.contains(n)) continue;
            
            int rb = n + 1;
            while(set.contains(rb)) {
                visited.add(rb);
                rb++;
            }
            
            int lb = n - 1;
            while(set.contains(lb)) {
                visited.add(lb);
                lb--;
            }
            
            res = Math.max(res, rb - lb - 1);
        }
        
        return res;
    }
}