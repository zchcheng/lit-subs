class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return List.of();
        
        Map<Character, char[]> keyMap = Map.of(
            '2', new char[] {'a', 'b', 'c'},
            '3', new char[] {'d', 'e', 'f'},
            '4', new char[] {'g', 'h', 'i'},
            '5', new char[] {'j', 'k', 'l'},
            '6', new char[] {'m', 'n', 'o'},
            '7', new char[] {'p', 'q', 'r', 's'},
            '8', new char[] {'t', 'u', 'v'},
            '9', new char[] {'w', 'x', 'y', 'z'}
        );
        
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        
        for(char d : digits.toCharArray()) {
            char[] chars = keyMap.get(d);
            
            int qSz = queue.size();
            
            for(int i = 0; i < qSz; i++) {
                String str = queue.poll();
                for(char c : chars) { queue.offer(str + c); }
            }
        }
        
        return (List<String>)queue;
    }
}