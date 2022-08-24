class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper("", 0, 0, n, res);
        return res;
    }
    
    void helper(String s, int open, int close, int n, List<String> res) {
        if (open == n && close == n) {
            res.add(s);
            return;
        }
        
        if (open < n) {
            helper(s + "(", open + 1, close, n, res);
        }
        
        if (close < open) {
            helper(s + ")", open, close + 1, n, res);
        }
    }
}