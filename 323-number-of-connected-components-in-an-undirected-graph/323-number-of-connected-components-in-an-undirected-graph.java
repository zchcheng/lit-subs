class Solution {
    int[] group = null;
    
    public int countComponents(int n, int[][] edges) {
        group = new int[n];
        
        for(int i = 0; i < n; i++) {
            group[i] = i;
        }
        
        for(int[] edge : edges) {
            join(edge[0], edge[1]);
        }
        
        Set<Integer> res = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            res.add(findGroup(i));
        }
        
        return res.size();
    }
    
    int findGroup(int n) {
        if (group[n] != n) {
            int root = findGroup(group[n]);
            group[n] = root;
        }
        return group[n];
    }
    
    void join(int a, int b) {
        int grp1 = findGroup(a);
        int grp2 = findGroup(b);
        group[grp2] = grp1;
    }
}