class Solution {
    int[] origin = null;
    int[] shuffled = null;
    Random rand = new Random();

    public Solution(int[] nums) {
        origin = nums;
        shuffled = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            shuffled[i] = nums[i];
        }
    }
    
    public int[] reset() {
        return origin;
    }
    
    public int[] shuffle() {
        for(int i = 0; i < shuffled.length; i++) {
            swap(i, Math.abs(rand.nextInt()) % shuffled.length);
        }
        return shuffled;
    }
    
    void swap(int a, int b) {
        int tmp = shuffled[a];
        shuffled[a] = shuffled[b];
        shuffled[b] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */