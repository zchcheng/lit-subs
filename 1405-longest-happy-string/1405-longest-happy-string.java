class Solution {
    public String longestDiverseString(int a, int b, int c) {
        int[] cnt = new int[] {a, b, c};
        
        StringBuilder sb = new StringBuilder();
        
        char forbid = ' ';
        while(true) {
            char next = getNext(cnt, forbid);
            
            if (next == ' ') {
                break;
            }
            
            sb.append(next);
            
            if (sb.length() > 1 && sb.charAt(sb.length() - 2) == next) {
                forbid = next;
                continue;
            }
            
            forbid = ' ';
        }
        
        return sb.toString();
    }
    
    char getNext(int[] cnt, char forbid) {
        int ca = (forbid == 'a')? 0 : cnt[0];
        int cb = (forbid == 'b')? 0 : cnt[1];
        int cc = (forbid == 'c')? 0 : cnt[2];
        
        if (ca == 0 && cb == 0 && cc == 0) return ' ';
        
        int max = Math.max(ca, Math.max(cb, cc));
        
        if (max == ca) {
            cnt[0]--;
            return 'a';
        }
        
        if (max == cb) {
            cnt[1]--;
            return 'b';
        }
        
        cnt[2]--;
        return 'c';
    }
}