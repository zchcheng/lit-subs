class Solution {
    public String longestCommonPrefix(String[] strs) {
        int ptr = 0;
        boolean end = false;
        
        while(!end) {
            Set<Character> chars = new HashSet<>();
            
            for(String str : strs) {
                if (str.length() <= ptr) {
                    end = true;
                    break;
                }
                chars.add(str.charAt(ptr));
            }
            
            if (chars.size() > 1) end = true;
            if (!end) ptr++;
        }
        
        return strs[0].substring(0, ptr);
    }
}