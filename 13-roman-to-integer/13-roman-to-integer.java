class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> valueMap = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );
        
        int result = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int v = valueMap.get(s.charAt(i));
            result += v;
            
            if (i > 0) {
                int pv = valueMap.get(s.charAt(i - 1));
                if (pv * 5 == v || pv * 10 == v) {
                    result -= 2 * pv;
                }
            }
        }
        
        return result;
    }
}