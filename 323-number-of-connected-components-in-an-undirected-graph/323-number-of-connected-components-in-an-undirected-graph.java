class Solution {
    int[] grp = null;
        
    public int countComponents(int n, int[][] edges) {
        grp = new int[n];
        
        for(int i = 0; i < n; i++) grp[i] = i;
        
        for(int[] edge : edges) union(edge[0], edge[1]);
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < n; i++) set.add(find(i));
        
        return set.size();
    }
    
    int find(int i) {
        if (grp[i] != i) {
            int g = find(grp[i]);
            grp[i] = g;
        }
        return grp[i];
    }
    
    void union(int a, int b) {
        int ga = find(a);
        int gb = find(b);
        grp[gb] = ga;
    }
}