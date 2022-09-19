class Solution {
    public String intToRoman(int num) {
        final List<Pair<Integer, String>> symbolValues = List.of(
            new Pair<>(1000, "M"),
            new Pair<>(900, "CM"),
            new Pair<>(500, "D"),
            new Pair<>(400, "CD"),
            new Pair<>(100, "C"),
            new Pair<>(90, "XC"),
            new Pair<>(50, "L"),
            new Pair<>(40, "XL"),
            new Pair<>(10, "X"),
            new Pair<>(9, "IX"),
            new Pair<>(5, "V"),
            new Pair<>(4, "IV"),
            new Pair<>(1, "I")
        );
        
        int index = 0;
        String result = "";
        
        while(num > 0) {
            Pair<Integer, String> p = symbolValues.get(index);
            
            if (num < p.getKey()) {
                index++;
                continue;
            }
            
            num -= p.getKey();
            result += p.getValue();
        }
        
        return result;
    }
}