class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        
        for(int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);
            
            String[] split = log.split(":");
            
            int nt = Integer.valueOf(split[2]);
            int np = Integer.valueOf(split[0]);
            
            if (split[1].equals("start")) {
                
                if (!stack.isEmpty()) {
                    int[] p = stack.peek();
                    res[p[0]] += nt - p[1];
                }
                
                stack.push(new int[] {np, nt});
                
            } else {
                
                int[] p = stack.pop();
                res[p[0]] += nt - p[1] + 1;
                
                if (!stack.isEmpty()) {
                    int[] prev = stack.peek();
                    prev[1] = nt + 1;
                }
                
            }
        }
        
        return res;
    }
}