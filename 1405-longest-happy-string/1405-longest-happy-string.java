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
        int max = Math.max(ca, Math.max(cb, cc));
        
        char res = ' ';
        
        if (max == 0);
        
        else if (max == ca) {
            cnt[0]--;
            res = 'a';
        } else if (max == cb) {
            cnt[1]--;
            res = 'b';
        } else if (max == cc) {
            cnt[2]--;
            res = 'c';
        }
        
        return res;
    }
}