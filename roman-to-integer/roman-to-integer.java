class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> numericValue = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );
        
        int result = 0;
        for(int i = 0, pv = 0; i < s.length(); i++) {
            int v = numericValue.get(s.charAt(i));
            result += v;
            
            if (v == pv * 5 || v == pv * 10) result -= pv * 2;
            
            pv = v;
        }
        
        return result;
    }
}