class Solution {
    public String pushDominoes(String d) {
        char[] arr = new char[d.length()];
        Arrays.fill(arr, '.');
        
        int pR = -1, pL = -1;
        for(int i = 0; i < d.length(); i++) {
            char c = d.charAt(i);
            
            if (c == '.') continue;
            
            if (c == 'R') {
                if (pR > pL) fill(arr, pR, i, 'R');
                pR = i;
                continue;
            }
            
            if (pL >= pR) fill(arr, pL + 1, i, 'L');
            else {
                int mid = (pR + i + 1) / 2;
                
                fill(arr, pR, mid - 1, 'R');
                fill(arr, mid + 1, i, 'L');
                
                if ((pR + i) % 2 != 0) arr[mid] = 'L';
            }
            
            pL = i;
        }
        
        if (pL < pR) fill(arr, pR, d.length() - 1, 'R');
        
        return String.valueOf(arr);
    }
    
    void fill(char[] arr, int from, int to, char l) {
        for(int i = from; i <= to; i++) {
            arr[i] = l;
        }
    }
}