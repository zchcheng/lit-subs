class Solution {
    public int triangularSum(int[] nums) {
        List<Long> coef = getCoef(nums.length);
        long result = 0;
        
        for(int i = 0; i < nums.length; i++) {
            result += coef.get(i) * nums[i];
            result %= 10;
        }
        
        return (int)result;
    }
    
    List<Long> getCoef(int n) {
        if (n == 1) return List.of(1l);
        
        List<Long> result = List.of(1l, 1l);
        
        for(int i = 2; i < n; i++) {
            List<Long> next = new ArrayList<>();
            
            for(int j = 0; j <= result.size(); j++) {
                long prev = (j == 0)? 0 : result.get(j - 1);
                long current = (j == result.size())? 0 : result.get(j);
                next.add((prev + current) % 10);
            }
            
            result = next;
        }
        
        return result;
    }
}