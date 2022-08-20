class Solution {
    int[] gid = null;
    
    public boolean validTree(int n, int[][] edges) {
        gid = new int[n];
        
        for(int i = 0; i < n; i++) gid[i] = i;
        
        for(int[] edge : edges) {
            if (!join(edge[0], edge[1])) return false;
        }
        
        int g = find(0);
        for(int i = 1; i < n; i++) {
            if (find(i) != g) return false;
        }
        
        return true;
    }
    
    int find(int n) {
        if (gid[n] != n) {
            gid[n] = find(gid[n]);
            return gid[n];
        }
        return n;
    }
    
    boolean join(int a, int b) {
        int ga = find(a);
        int gb = find(b);
        if (ga == gb) return false;
        
        gid[gb] = ga;
        
        return true;
    }
}