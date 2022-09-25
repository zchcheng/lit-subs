class Solution {
    // A: 0, 2
    // B: 1
    // 
    
    public int uniqueLetterString(String s) {
        Map<Character, List<Integer>> indexOfLetters = new HashMap<>();
        int[][] prevAndNext = new int[s.length()][2];
        
        for(int i = 0; i < s.length(); i++) {
            indexOfLetters.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        }
        
        for(Map.Entry<Character, List<Integer>> kv : indexOfLetters.entrySet()) {
            List<Integer> list = kv.getValue();
            
            for(int i = 0; i < list.size(); i++) {
                int idx = list.get(i);
                
                int prev = (i == 0)? -1 : list.get(i - 1);
                int next = (i == list.size() - 1)? s.length() : list.get(i + 1);
                
                prevAndNext[idx] = new int[] {prev, next};
            }
        }
        
        int res = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int prev = prevAndNext[i][0];
            int next = prevAndNext[i][1];
            
            res += (i - prev) * (next - i);
        }
        
        return res;
    }
}