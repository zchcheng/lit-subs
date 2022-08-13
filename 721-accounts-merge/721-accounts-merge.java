class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < accounts.size(); i++) {
            List<String> acc = accounts.get(i);
            for(int j = 1; j < acc.size(); j++) {
                String email = acc.get(j);
                Set<Integer> set = map.computeIfAbsent(email, k -> new HashSet());
                set.add(i);
            }
        }
        
        int[] gid = new int[accounts.size()];
        for(int i = 0; i < gid.length; i++) {
            gid[i] = i;
        }
        
        for(Map.Entry<String, Set<Integer>> kv : map.entrySet()) {
            List<Integer> list = new ArrayList<>(kv.getValue());
            for(int i : list) {
                for(int j : list) {
                    if (i != j) union(gid, i, j);
                }
            }
        }
        
        Map<Integer, Set<String>> groups = new HashMap<>();
        for(int i = 0; i < accounts.size(); i++) {
            int g = find(gid, i);
            Set<String> emails = groups.computeIfAbsent(g, k -> new HashSet<>());
            List<String> account = accounts.get(i);
            emails.addAll(account.subList(1, account.size()));
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for(Map.Entry<Integer, Set<String>> kv : groups.entrySet()) {
            List<String> account = new ArrayList<>();
            String name = accounts.get(kv.getKey()).get(0);
            account.add(name);
            List<String> emails = new ArrayList<>(kv.getValue());
            Collections.sort(emails);
            account.addAll(emails);
            res.add(account);
        }
        
        return res;
    }
    
    int find(int[] gid, int n) {
        if (gid[n] == n) {
            return n;
        }
        return find(gid, gid[n]);
    }
    
    void union(int[] gid, int a, int b) {
        int ga = find(gid, a);
        int gb = find(gid, b);
        gid[gb] = ga;
    }
}