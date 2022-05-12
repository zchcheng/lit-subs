class Solution {
    public String intToRoman(int num) {
        List<Pair<Integer, String>> list = List.of(
            new Pair(1000, "M"),
            new Pair(900, "CM"),
            new Pair(500, "D"),
            new Pair(400, "CD"),
            new Pair(100, "C"),
            new Pair(90, "XC"),
            new Pair(50, "L"),
            new Pair(40, "XL"),
            new Pair(10, "X"),
            new Pair(9, "IX"),
            new Pair(5, "V"),
            new Pair(4, "IV"),
            new Pair(1, "I")
        );
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < list.size();) {
            Pair<Integer, String> p = list.get(i);
            if (num < p.getKey()) {
                i++;
                continue;
            }
            
            sb.append(p.getValue());
            num -= p.getKey();
        }
        
        return sb.toString();
    }
}