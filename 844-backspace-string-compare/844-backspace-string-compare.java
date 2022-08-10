class Solution {
    public boolean backspaceCompare(String s, String t) {
        int ps = s.length() - 1;
        int pt = t.length() - 1;
        
        while(ps >= 0 && pt >= 0) {
            ps = getNextValidCharPointer(s, ps);
            pt = getNextValidCharPointer(t, pt);
            
            if (ps >= 0 && pt >= 0) {
                if (s.charAt(ps) != t.charAt(pt)) return false;
                ps -= 1;
                pt -= 1;
            }
        }
        
        ps = getNextValidCharPointer(s, ps);
        pt = getNextValidCharPointer(t, pt);
        
        return ps < 0 && pt < 0;
    }
    
    int getNextValidCharPointer(String s, int pointer) {
        int skip = 0;
        while(pointer >= 0 && (s.charAt(pointer) == '#' || skip > 0))  {
            if (s.charAt(pointer) == '#') skip += 1; 
            else skip -= 1;
            pointer -= 1;
        }
        return pointer;
    }
}