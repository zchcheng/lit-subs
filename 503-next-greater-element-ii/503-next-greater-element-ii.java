class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // [1,2,3,3,1] 
        // stack: 2(3), 3(3), 4(1)
        //
        // [1, 2, -1, -1, 3]
        //
        
        int[] result = new int[nums.length];
        
        Arrays.fill(result, -1);
            
        Deque<Integer> stack = new LinkedList<>();
        
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            
            while(!stack.isEmpty() && nums[stack.peek()] < n) {
                result[stack.pop()] = n;
            }
            
            stack.push(i);
        }
        
        for(int i = 0; i < nums.length && !stack.isEmpty(); i++) {
            int n = nums[i];
            
            while(!stack.isEmpty() && nums[stack.peek()] < n) {
                result[stack.pop()] = n;
            }
            
            if (i == stack.peekLast()) break;
        }
        
        return result;
    }
}