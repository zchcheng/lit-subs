class Solution {
    public String pushDominoes(String d) {
        char[] arr = new char[d.length()];
        Arrays.fill(arr, '.');
        
        int prevR = -1;
        int prevL = -1;
        for(int i = 0; i < d.length(); i++) {
            char c = d.charAt(i);
            
            if (c == '.') continue;
            
            if (c == 'R') {
                if (prevR > prevL) {
                    for(int j = Math.max(0, prevR); j <= i; j++) arr[j] = 'R';
                }
                prevR = i;
                continue;
            }
            
            if (prevL >= prevR) {
                for(int j = prevL + 1; j <= i; j++) arr[j] = 'L';
            } else {
                int mid = (prevR + i + 1) / 2;

                for(int j = prevR; j < mid; j++) {
                    arr[j] = 'R';
                }

                for(int j = i; j > mid; j--) {
                    arr[j] = 'L';
                }
                
                if ((prevR + i) % 2 != 0) arr[mid] = 'L';
            }
            
            prevL = i;
        }
        
        if (prevL < prevR) {
            for(int i = prevR; i < d.length(); i++) arr[i] = 'R';
        }
        
        return String.valueOf(arr);
    }
}