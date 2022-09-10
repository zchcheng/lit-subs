class Solution {
    Map<Integer, List<String>> memo = new HashMap<>();
    
    public List<String> generateParenthesis(int n) {
        if (n == 0) return List.of("");
        
        if (memo.containsKey(n)) return memo.get(n);
        
        List<String> res = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            for(String s1 : generateParenthesis(i)) {
                for(String s2 : generateParenthesis(n - i - 1)) {
                    res.add(s1 + "(" + s2 + ")");
                }
            }
        }
        
        memo.put(n, res);
        
        return res;
    }
}
