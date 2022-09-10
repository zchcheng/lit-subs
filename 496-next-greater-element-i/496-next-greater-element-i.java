class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        
        Map<Integer, Integer> nge = new HashMap<>();
        
        for(int n : nums2) {
            while(!stack.isEmpty() && stack.peek() < n) {
                int l = stack.pop();
                if (!nge.containsKey(l)) {
                    nge.put(l, n);
                }
            }
            stack.push(n);
        }
        
        int[] res = new int[nums1.length];
        
        for(int i = 0; i < nums1.length; i++) {
            res[i] = nge.getOrDefault(nums1[i], -1);
        }
        
        return res;
    }
}