class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        List<int[]> list = new ArrayList<>();
        
        int[] current = null;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                if (current != null) {
                    current[1] = i;
                    list.add(current);
                }
                current = new int[] {i, i};
            }
        }
        
        int[] result = new int[queries.length];
        
        for(int i = 0; i < queries.length; i++) {
            result[i] = binSearch(list, queries[i]);
        }
        
        return result;
    }
    
    int binSearch(List<int[]> list, int[] query) {
        int head = -1;
        int tail = -1;
        
        // upper bound
        {
            int l = 0;
            int r = list.size() - 1;
            int q = query[0];

            while(l <= r) {
                int m = l + (r - l) / 2;
                
                int[] p = list.get(m);
                
                if (p[0] < q) l = m + 1;
                else r = m - 1;
            }
            
            head = l;
        }
        
        // lower bound
        {
            int l = 0;
            int r = list.size() - 1;
            int q = query[1];

            while(l <= r) {
                int m = l + (r - l) / 2;
                
                int[] p = list.get(m);
                
                if (p[1] <= q) l = m + 1;
                else r = m - 1;
            }
            
            tail = r;
        }
        
        if (head >= list.size() || tail < 0) return 0;
        
        int[] ph = list.get(head);
        int[] pt = list.get(tail);
        
        return Math.max(pt[1] - ph[0] - (tail - head + 1), 0);
    }
}