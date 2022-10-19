class Solution {
    public boolean increasingTriplet(int[] nums) {
        Integer a = null;
        Integer b = null;
        Integer c = null;
        
        for(int i : nums) {
            if (b != null && i > b) return true;
            if (a == null || i < a) {
                a = i;
                continue;
            }
            if (i > a && (b == null || i < b)) b = i;
        }
        
        return false;
    }
}