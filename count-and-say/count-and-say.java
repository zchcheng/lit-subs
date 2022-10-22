class Solution {
    public String countAndSay(int n) {
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(1);
        
        for(int i = 0; i < n - 1; i++) {
            int sz = q.size(), cnt = 0, prev = q.peek();
            
            for(int j = 0; j < sz; j++) {
                int k = q.poll();
                
                if  (prev == k) {
                    cnt++;
                    continue;
                } 
                
                q.offer(cnt);
                q.offer(prev);
                cnt = 1;
                prev = k;
            }
            
            q.offer(cnt);
            q.offer(prev);
        }
        
        return toString((LinkedList<Integer>)q);
    }
    
    String toString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        
        for(int i : list) sb.append(i);
        
        return sb.toString();
    }
}