class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        
        for(String s : logs) {
            if (isDigit(s)) digits.add(s);
            else letters.add(s);
        }
        
        letters.sort((String a, String b) -> {
            String[] sa = a.split(" ", 2);
            String[] sb = b.split(" ", 2);
            if (sa[1].equals(sb[1])) return sa[0].compareTo(sb[0]);
            return sa[1].compareTo(sb[1]);
        });
        
        String[] res = new String[logs.length];
        
        int idx = 0;
        for(int i = 0; i < letters.size(); i++) { res[idx++] = letters.get(i); }
        for(int i = 0; i < digits.size(); i++) { res[idx++] = digits.get(i); }
        
        return res;
    }
    
    boolean isDigit(String s) {
        String[] split = s.split(" ");
        for(int i = 1; i < split.length; i++) {
            for(char c : split[i].toCharArray()) {
                if (!Character.isDigit(c)) return false;
            }
        }
        return true;
    }
}