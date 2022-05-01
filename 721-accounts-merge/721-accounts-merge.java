class Solution {
    int[] parent;
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        parent = new int[accounts.size()];
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < parent.length; i++) {
            List<String> acc = accounts.get(i);
            
            for(int j = 1; j < acc.size(); j++) {
                
                String email = acc.get(j);
                Integer id = map.get(email);
                
                if (id == null) {
                    map.put(email, i);
                    continue;
                }
                
                union(i, id);
            }
        }
        
        Map<Integer, Set<String>> emails = new HashMap<>();
        
        for(int i = 0; i < parent.length; i++) {
            int id = find(parent[i]);
            Set<String> s = emails.getOrDefault(id, new HashSet<>());
            List<String> acc = accounts.get(i);
            
            for(int j = 1; j < acc.size(); j++) {
                s.add(acc.get(j));
            }
            
            emails.put(id, s);
        }
        
        List<List<String>> res = new ArrayList<>();
        
        for(Map.Entry<Integer, Set<String>> kv : emails.entrySet()) {
            List<String> info = new ArrayList<>();
            String name = accounts.get(kv.getKey()).get(0);
            
            info.add(name);
            List<String> es = new ArrayList<>(kv.getValue());
            es.sort((String a, String b) -> a.compareTo(b));
            info.addAll(es);
            
            res.add(info);
        }
        
        return res;
    }
    
    int find(int id) {
        if (parent[id] != id) {
            int pid = find(parent[id]);
            parent[id] = pid;
        }
        return parent[id];
    }
    
    void union(int a, int b) {
        int id1 = find(a);
        int id2 = find(b);
        if (id1 == id2) return;
        parent[id2] = id1;
    }
}