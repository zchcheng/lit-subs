class Solution {
    public int numDecodings(String s) {
        return helper(s, 0, new HashMap<>());
    }
    
    int helper(String s, int i, Map<Integer, Integer> memo) {
        if (i >= s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        
        boolean canTakeTwoDigits = (i < s.length() - 1) && Character.getNumericValue(s.charAt(i)) * 10 + Character.getNumericValue(s.charAt(i + 1)) <= 26;
        
        int res = (canTakeTwoDigits)? 
            helper(s, i + 1, memo) + helper(s, i + 2, memo) : helper(s, i + 1, memo);
        
        memo.put(i, res);
        
        return res;
    }
}