class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        
        List<Character> list = new ArrayList<>();
        for(char c : s.toCharArray()) {
            list.add(c);
        }
        
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character a, Character b) {
                return map.getOrDefault(a, Integer.MAX_VALUE) - map.getOrDefault(b, Integer.MAX_VALUE);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(char c : list) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}