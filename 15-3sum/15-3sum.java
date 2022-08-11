class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Set<Integer> dup = new HashSet<>();
        
        for(int i = 0; i < nums.length - 2; i++) {
            Set<Integer> set = new HashSet<>();
            for(int j = i + 1; j < nums.length; j++) {
                int target = -(nums[i] + nums[j]);
                if (set.contains(target)) {
                    List<Integer> cand = List.of(nums[i], nums[j], target);
                    int hash = hashCode(cand);
                    if (!dup.contains(hash)) {
                        dup.add(hash);
                        res.add(cand);
                    }
                }
                set.add(nums[j]);
            }
        }
        
        return res;
    }
    
    int hashCode(List<Integer> list) {
        int[] arr = new int[] { list.get(0), list.get(1), list.get(2) };
        Arrays.sort(arr);
        return (arr[0] + ";" + arr[1] + ";" + arr[2]).hashCode();
    }
}