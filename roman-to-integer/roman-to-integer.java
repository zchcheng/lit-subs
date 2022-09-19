class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> symbolValue = Map.of(
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
            char c = s.charAt(i);
            
            result += symbolValue.get(c);
            
            if (i > 0 && (
                symbolValue.get(s.charAt(i - 1)) * 5 == symbolValue.get(c) || 
                symbolValue.get(s.charAt(i - 1)) * 10 == symbolValue.get(c)
            )) {
                result -= symbolValue.get(s.charAt(i - 1)) * 2;
            }
        }
        
        return result;
    }
}