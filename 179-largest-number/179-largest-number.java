class Solution {
    public String largestNumber(int[] nums) {
        List<String> strings = new ArrayList<>();
        for(int num : nums) {
            strings.add(String.valueOf(num));
        }
        
        Collections.sort(strings, (a, b) -> {
            return -(a+b).compareTo(b+a);
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : strings) {
            sb.append(s);
        }
        
        while(sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0);
        
        return sb.toString();
    }
}