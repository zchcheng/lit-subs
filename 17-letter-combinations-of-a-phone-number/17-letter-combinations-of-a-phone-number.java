class Solution {
    Map<Character, char[]> keymap = Map.of(
        '2', new char[] {'a', 'b', 'c'},
        '3', new char[] {'d', 'e', 'f'},
        '4', new char[] {'g', 'h', 'i'},
        '5', new char[] {'j', 'k', 'l'},
        '6', new char[] {'m', 'n', 'o'},
        '7', new char[] {'p', 'q', 'r', 's'},
        '8', new char[] {'t', 'u', 'v'},
        '9', new char[] {'w', 'x', 'y', 'z'}
    );
        
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        
        if (digits.isEmpty()) return res;
        
        res.add("");
        
        return helper((Queue<String>)res, digits.toCharArray(), 0);
    }
    
    List<String> helper(Queue<String> q, char[] digits, int idx) {
        if (idx >= digits.length) return (List<String>)q;
        
        char[] arr = keymap.get(digits[idx]);
        
        if (arr == null) {
            return helper(q, digits, idx + 1);
        }
        
        int size = q.size();
        
        for(int i = 0; i < size; i++) {
            String str = q.poll();
            for(char c : arr) {
                q.offer(str + c);
            }
        }
        
        return helper(q, digits, idx + 1);
    }
}