class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> coef = getCoef(nums.length);
        int result = 0;
        
        for(int i = 0; i < nums.length; i++) {
            result += coef.get(i) * nums[i];
            result %= 10;
        }
        
        return result;
    }
    
    List<Integer> getCoef(int n) {
        if (n == 1) return List.of(1);
        
        List<Integer> result = List.of(1, 1);
        
        for(int i = 2; i < n; i++) {
            List<Integer> next = new ArrayList<>();
            
            for(int j = 0; j <= result.size(); j++) {
                int prev = (j == 0)? 0 : result.get(j - 1);
                int current = (j == result.size())? 0 : result.get(j);
                next.add((prev + current) % 10);
            }
            
            result = next;
        }
        
        return result;
    }
}